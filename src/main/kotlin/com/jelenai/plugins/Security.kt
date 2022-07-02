package com.jelenai.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.jelenai.util.Constants.JWT_AUDIENCE
import com.jelenai.util.Constants.JWT_ISSUER
import com.jelenai.util.Constants.JWT_REALM
import com.jelenai.util.Constants.JWT_SECRET
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

fun Application.configureSecurity() {
    authentication {
        jwt {
            realm = JWT_REALM
            verifier(
                JWT
                    .require(Algorithm.HMAC256(JWT_SECRET))
                    .withAudience(JWT_AUDIENCE)
                    .withIssuer(JWT_ISSUER)
                    .build()
            )
            validate { credential ->
                if (credential.payload.audience.contains(JWT_AUDIENCE)) {
                    JWTPrincipal(credential.payload)
                } else null
            }
        }
    }
}

val JWTPrincipal.userId: String?
    get() = getClaim("userId", String::class)
