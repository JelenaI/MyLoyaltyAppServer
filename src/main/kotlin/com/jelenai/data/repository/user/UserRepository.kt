package com.jelenai.data.repository.user

import com.jelenai.data.models.User
import org.litote.kmongo.coroutine.CoroutineFindPublisher

interface UserRepository {
    suspend fun createUser(user: User)

    suspend fun getUserById(id: String): User?

    suspend fun getUserByEmail(email: String): User?

    suspend fun doesPasswordForUserMatch(email: String, enteredPassword: String): Boolean

    suspend fun doesEmailBelongToUserId(email: String, userId: String): Boolean

    suspend fun getAllUsers(): CoroutineFindPublisher<User>
}