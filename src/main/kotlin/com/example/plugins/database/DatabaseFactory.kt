package com.example.plugins.database

import com.example.plugins.entity.UserScores
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init(){
        Database.connect(hikari())
    }
    fun createTable(){
        transaction {
            SchemaUtils.create(UserScores)
        }
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "com.mysql.cj.jdbc.Driver"
        config.jdbcUrl = "jdbc:mysql://127.0.0.1:3306/mygame"
        config.username = "root"
        config.password = "*Tttt90015"
        config.validate()
        return HikariDataSource(config)
    }
}