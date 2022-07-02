package com.jelenai.service

import com.jelenai.data.models.User
import com.jelenai.data.repository.user.UserRepository
import com.jelenai.data.requests.CreateAccountRequest
import com.jelenai.data.responses.ProfileResponse

class UserService(private val userRepository: UserRepository) {
    suspend fun doesUserWithEmailExist(email: String): Boolean {
        return userRepository.getUserByEmail(email) != null
    }

    suspend fun getUserProfile(userId: String): ProfileResponse? {
        val user = userRepository.getUserById(userId) ?: return null
        return ProfileResponse(
            id = user._id_,
            username = user.username,
            firstName = user.firstName,
            lastName = user.lastName,
            phoneNumber = user.phoneNumber,
            email = user.email
        )
    }

    suspend fun getUserByEmail(email: String): User? {
        return userRepository.getUserByEmail(email)
    }

    fun isValidPassword(enteredPassword: String, actualPassword: String): Boolean {
        return enteredPassword == actualPassword
    }

    suspend fun createUser(request: CreateAccountRequest) {
        userRepository.createUser(
            User(
                email = request.email,
                username = request.username,
                password = request.password,
                firstName = request.firstName,
                lastName = request.lastName,
                phoneNumber = request.phoneNumber
            )
        )
    }

    fun validateCreateAccountRequest(request: CreateAccountRequest): UserService.ValidationEvent {
        if (request.email.isBlank() || request.password.isBlank() || request.username.isBlank()) {
            return ValidationEvent.ErrorFieldEmpty
        }

        return ValidationEvent.Success
    }

//    fun getAllUsers(): List<ProfileResponse> {
//        val result: List<ProfileResponse> = mutableListOf()
//        val users = userRepository.getAllUsers()
//
//        for (user in users) {
//            result.
//        }
//        return userRepository.getAllUsers()
//    }

    sealed class ValidationEvent {
        object ErrorFieldEmpty : ValidationEvent()
        object Success : ValidationEvent()
    }
}