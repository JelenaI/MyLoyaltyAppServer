package com.jelenai.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class User(
    @BsonId
    val _id_: String = ObjectId().toString(),
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val username: String,
    val password: String,
    val points: List<Points>
)