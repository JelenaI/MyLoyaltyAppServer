package com.jelenai.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Pharmacy(
    val id: String? = null,
    val name: String,
    val branches: List<Branch>
)

@Serializable
data class Branch(
    val name: String,
    val address: String,
    val phoneNumber: String,
    val longitude: String,
    val latitude: String,
    val workingHours: List<WorkingHours>
)

@Serializable
data class WorkingHours(
    val dayOfWeek: String,
    val startHours: String,
    val endHours: String
)
