package com.jelenai.routes

import com.jelenai.plugins.userId
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

val ApplicationCall.userId: String
    get() = principal<JWTPrincipal>()?.userId.toString()