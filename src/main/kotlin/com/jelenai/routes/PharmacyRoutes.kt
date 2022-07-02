package com.jelenai.routes

import com.jelenai.data.models.Pharmacy
import com.jelenai.data.models.pharmacyStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.pharmacyRouting() {
    route("/pharmacy") {
        get {
            if (pharmacyStorage.isNotEmpty()) {
                call.respond(pharmacyStorage)
            } else {
                call.respondText("No pharmacies found", status = HttpStatusCode.OK)
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val pharmacy =
                pharmacyStorage.find { it.id == id } ?: return@get call.respondText(
                    "No pharmacy with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(pharmacy)
        }
        post {
            val pharmacy = call.receive<Pharmacy>()
            pharmacyStorage.add(pharmacy)
            call.respondText("Pharmacy stored correctly", status = HttpStatusCode.Created)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (pharmacyStorage.removeIf { it.id == id }) {
                call.respondText("Pharmacy removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }
}