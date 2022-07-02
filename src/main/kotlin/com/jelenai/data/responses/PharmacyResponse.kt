package com.jelenai.data.responses

import com.jelenai.data.models.PharmacyBranch
import kotlinx.serialization.Serializable

@Serializable
class PharmacyResponse(
    val id: String?,
    val name: String,
    val branches: List<PharmacyBranch>
)