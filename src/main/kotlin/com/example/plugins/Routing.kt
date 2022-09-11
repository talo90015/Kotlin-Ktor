package com.example.plugins

import com.example.plugins.model.UserScore
import com.example.plugins.repository.UserScoreRepository
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World! Potato")
        }
    }
}

