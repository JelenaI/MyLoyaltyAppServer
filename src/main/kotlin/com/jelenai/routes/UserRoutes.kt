package com.jelenai.routes

import com.jelenai.data.responses.BasicApiResponse
import com.jelenai.service.UserService
import com.jelenai.util.ApiResponseMessages
import com.jelenai.util.QueryParams
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getUserProfile(userService: UserService) {
    authenticate() {
        get("/user/profile") {
            val userId = call.parameters[QueryParams.PARAM_USER_ID]
            if (userId == null || userId.isBlank()) {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }
            val profileResponse = userService.getUserProfile(userId)
            if (profileResponse == null) {
                call.respond(
                    HttpStatusCode.OK,
                    BasicApiResponse<Unit>(
                        successful = false,
                        message = ApiResponseMessages.USER_NOT_FOUND
                    )
                )
                return@get
            }
            call.respond(
                HttpStatusCode.OK,
                BasicApiResponse(
                    successful = true,
                    data = profileResponse
                )
            )
        }
    }
}

fun Route.getUserByEmail(userService: UserService) {
    authenticate() {
        get("/user") {
            val email = call.parameters[QueryParams.PARAM_USER_EMAIL]
            if (email == null || email.isBlank()) {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }
            val profileResponse = userService.getUserByEmail(email = email)
            println("USER ID " + profileResponse?._id_)
            if (profileResponse == null) {
                call.respond(
                    HttpStatusCode.OK,
                    BasicApiResponse<Unit>(
                        successful = false,
                        message = ApiResponseMessages.USER_NOT_FOUND
                    )
                )
                return@get
            }
            call.respond(
                HttpStatusCode.OK,
                BasicApiResponse(
                    successful = true,
                    data = profileResponse
                )
            )
        }
    }
}