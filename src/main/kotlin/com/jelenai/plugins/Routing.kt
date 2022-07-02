package com.jelenai.plugins

import com.jelenai.routes.*
import com.jelenai.service.UserService
import com.jelenai.util.Constants.JWT_AUDIENCE
import com.jelenai.util.Constants.JWT_ISSUER
import com.jelenai.util.Constants.JWT_SECRET
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val userService: UserService by inject()

    routing {
        // User routes
        authenticate()
        createUser(userService)
        loginUser(
            userService = userService,
            jwtIssuer = JWT_ISSUER,
            jwtAudience = JWT_AUDIENCE,
            jwtSecret = JWT_SECRET
        )
        getUserProfile(userService)
        getUserByEmail(userService)

        // Pharmacy routes
        pharmacyRouting()

        // Static resources
        static("/static") {
            resources("static")
        }
    }
}
