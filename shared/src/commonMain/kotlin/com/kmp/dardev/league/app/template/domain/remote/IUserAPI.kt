package com.kmp.dardev.league.app.template.domain.remote

import com.kmp.dardev.league.app.template.domain.model.User

interface IUserAPI {
    suspend fun getUserById(userGuid:String,jwtToken: String): User?
}