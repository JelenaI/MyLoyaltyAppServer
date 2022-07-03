package com.jelenai

import com.jelenai.di.mainModule
import com.jelenai.plugins.configureRouting
import com.jelenai.plugins.configureSecurity
import com.jelenai.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.plugin.Koin

fun main() {
    embeddedServer(Netty, port = 8100, host = "0.0.0.0") {
        install(Koin) {
            modules(mainModule)
        }
        configureRouting()
        configureSecurity()
        configureSerialization()
    }.start(wait = true)
}
