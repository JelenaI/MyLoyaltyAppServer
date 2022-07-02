package com.jelenai.data.requests

import kotlinx.serialization.Serializable

@Serializable
data class CreateAccountRequest(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val username: String,
    val password: String
)
