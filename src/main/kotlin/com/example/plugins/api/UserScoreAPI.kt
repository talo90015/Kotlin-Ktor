package com.example.plugins.api

import com.example.plugins.model.UserScore
import com.example.plugins.service.UserService
import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.UserScoreAPI(){
    post("/uploadScore") {
        var data = Gson().fromJson(call.receive<String>(), UserScore::class.java)
        if (data == null){
            call.respond(HttpStatusCode.BadRequest, "不存在資料")
        }else{
            UserService().saveScore(data)
            call.respond(HttpStatusCode.OK)
        }
    }
    get ("/getRankList"){
        call.respond(HttpStatusCode.OK, UserService().getRankList().toString())
    }
}