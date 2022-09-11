package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.plugins.database.DatabaseFactory
import com.example.plugins.model.UserScore
import com.example.plugins.repository.UserScoreRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "127.0.0.1"
    ) {
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}


