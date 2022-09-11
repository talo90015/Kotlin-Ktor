package com.example.plugins.service

import com.example.plugins.model.UserScore
import com.example.plugins.repository.UserScoreRepository

class UserService {
    val userScoreRepository = UserScoreRepository()
    suspend fun saveScore(data:UserScore){
        if (userScoreRepository.get() == null){
            userScoreRepository.add(data)
        }else{
            userScoreRepository.update(data)
        }
    }

    suspend fun getRankList(): UserScore? {
        return userScoreRepository.get()
    }
}