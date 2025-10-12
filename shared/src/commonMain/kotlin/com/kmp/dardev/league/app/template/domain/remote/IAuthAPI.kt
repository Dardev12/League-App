package com.kmp.dardev.league.app.template.domain.remote

import com.kmp.dardev.league.app.template.domain.model.SignInData
import com.kmp.dardev.league.app.template.domain.model.SignUpData
import com.kmp.dardev.league.app.template.domain.model.TokenConnexion

interface IAuthAPI {
    suspend fun signUpToApp(signUpData: SignUpData): TokenConnexion?
    suspend fun signInToApp(signInData: SignInData): TokenConnexion?
    suspend fun refreshJWTToken(token: String,userId: String): TokenConnexion?
}