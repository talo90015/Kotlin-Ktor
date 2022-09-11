package com.example.plugins.repository

import com.example.plugins.entity.UserScores
import com.example.plugins.entity.UserScores.user
import com.example.plugins.model.UserScore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class UserScoreRepository {
    suspend fun add(data: UserScore){
        transaction {
            UserScores.insert {
                it[user] = data.user
                it[score] =  data.score
                it[updateTime] = System.currentTimeMillis()
            }
        }
    }
    suspend fun update(data: UserScore){
        transaction {
            UserScores.update({(UserScores.user eq data.user) and (UserScores.score less data.score)}){
                it[score] = data.score
                it[updateTime] = System.currentTimeMillis()
            }
        }
    }
    suspend fun get(): UserScore?{
        return transaction {
            UserScores.select { UserScores.user eq user }.mapNotNull {
                toUSerScore(it)
            }.singleOrNull()
        }
    }
    private fun toUSerScore(row: ResultRow): UserScore =
        UserScore(
            id = row[UserScores.id].value,
            user = row[UserScores.user],
            score = row[UserScores.score]
        )
}