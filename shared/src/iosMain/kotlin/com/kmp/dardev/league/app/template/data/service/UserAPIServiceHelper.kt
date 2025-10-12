package com.kmp.dardev.league.app.template.data.service

import com.kmp.dardev.league.app.template.domain.model.User
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UserAPIServiceHelper: KoinComponent {
    private val service: UserAPIService by inject()

    suspend fun getUserData(userGuid: String,jwtToken: String): User? {
        return service.getUserData(userGuid,jwtToken)
    }

}