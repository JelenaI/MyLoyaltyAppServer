package com.jelenai.data.responses

import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    val id: String?,
    val username: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String
)
