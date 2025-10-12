package com.kmp.dardev.league.app.template.data.service

import com.kmp.dardev.league.app.template.domain.model.User
import com.kmp.dardev.league.app.template.domain.remote.IUserAPI

class UserAPIService(
    private val userAPI: IUserAPI
) {
    suspend fun getUserData(userGuid: String,jwtToken: String): User? {
        return userAPI.getUserById(userGuid,jwtToken)
    }

}