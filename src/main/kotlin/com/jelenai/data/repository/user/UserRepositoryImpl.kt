package com.jelenai.data.repository.user

import com.jelenai.data.models.User
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.CoroutineFindPublisher
import org.litote.kmongo.eq

class UserRepositoryImpl(db: CoroutineDatabase) : UserRepository {
    private val users = db.getCollection<User>()

    override suspend fun createUser(user: User) {
        users.insertOne(user)
    }

    override suspend fun getUserById(id: String): User? {
        return users.findOneById(id)
    }

    override suspend fun getUserByEmail(email: String): User? {
        var user = users.findOne(User::email eq email)

        if (user == null) {
            user = users.findOne(User::username eq email)
        }

        return user
    }

    override suspend fun doesPasswordForUserMatch(email: String, enteredPassword: String): Boolean {
        return getUserByEmail(email)?.password == enteredPassword
    }

    override suspend fun doesEmailBelongToUserId(email: String, userId: String): Boolean {
        return users.findOneById(userId)?.email == email
    }

    override suspend fun getAllUsers(): CoroutineFindPublisher<User> {
        return users.find()
    }
}