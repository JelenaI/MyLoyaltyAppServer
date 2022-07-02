package com.jelenai.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Points(
    val pharmacy: String,
    val numberOfPoints: String
)