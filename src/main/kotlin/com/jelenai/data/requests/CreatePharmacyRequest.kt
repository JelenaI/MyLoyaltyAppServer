package com.jelenai.data.requests

import com.jelenai.data.models.Branch
import kotlinx.serialization.Serializable

@Serializable
data class CreatePharmacyRequest(
    val name: String,
    val branches: List<Branch>
)