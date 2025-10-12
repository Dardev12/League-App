package com.kmp.dardev.league.app.template.domain.service

import com.kmp.dardev.league.app.template.domain.model.User

interface IFirebaseUserService {
    suspend fun getUserDataById(id:String): User
    suspend fun getUserCurrentUID():String
    suspend fun modifyUsername(username:String)
    suspend fun modifyEmail(email:String)
    suspend fun modifyPassword(password:String)
    suspend fun userSignOut()
}