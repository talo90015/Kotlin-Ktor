package com.example.plugins

import com.example.plugins.api.UserScoreAPI
import com.example.plugins.database.DatabaseFactory
import com.example.plugins.model.UserScore
import com.example.plugins.repository.UserScoreRepository
import com.google.gson.Gson
import io.ktor.http.*

import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.gson.gson
import io.ktor.serialization.kotlinx.json.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
//        json()
        Gson()
    }
    DatabaseFactory.init()
    DatabaseFactory.createTable()
    routing {
        UserScoreAPI()
        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
    }
}

