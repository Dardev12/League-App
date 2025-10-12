package com.kmp.dardev.league.app.template.data.service

import com.kmp.dardev.league.app.template.domain.model.SignInData
import com.kmp.dardev.league.app.template.domain.model.SignUpData
import com.kmp.dardev.league.app.template.domain.model.TokenConnexion
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthAPIServiceHelper: KoinComponent {
    private val service: AuthAPIService by inject()

    suspend fun signUp(signUpData: SignUpData): TokenConnexion? {
        return service.signUp(signUpData)
    }

    suspend fun signIn(signInData: SignInData): TokenConnexion?? {
        return service.signIn(signInData)
    }

    suspend fun refreshToken(token: String,userId: String): TokenConnexion? {
        return service.refreshToken(token,userId)
    }

}