package com.jelenai.data.responses

import com.jelenai.data.models.WorkingHours
import kotlinx.serialization.Serializable

@Serializable
class BranchResponse(
    val name: String,
    val address: String,
    val phoneNumber: String,
    val longitude: String,
    val latitude: String,
    val workingHours: List<WorkingHours>
)