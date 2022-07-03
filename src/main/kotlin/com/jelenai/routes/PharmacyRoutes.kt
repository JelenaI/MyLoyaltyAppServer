package com.jelenai.routes

import com.jelenai.service.PharmacyService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.pharmacyRouting(pharmacyService: PharmacyService) {
    get("/pharmacies") {
        val pharmacesResponse = pharmacyService.getAllPharmacies()

        if (pharmacesResponse.isNotEmpty()) {
            call.respond(pharmacesResponse)
        } else {
            call.respondText("No pharmacies found", status = HttpStatusCode.OK)
        }
    }

    get("/branches") {
        val branchesResponse = pharmacyService.getAllBranches()

        if (branchesResponse.isNotEmpty()) {
            call.respond(branchesResponse)
        } else {
            call.respondText("No branches found", status = HttpStatusCode.OK)
        }
    }
}