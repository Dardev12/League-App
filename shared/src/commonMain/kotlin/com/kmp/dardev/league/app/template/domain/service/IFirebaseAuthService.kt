package com.kmp.dardev.league.app.template.domain.service

import com.kmp.dardev.league.app.template.domain.model.SignInData
import com.kmp.dardev.league.app.template.domain.model.SignUpData

interface IFirebaseAuthService {
    suspend fun signInFirebaseService(signInData: SignInData)
    suspend fun signUpFirebaseService(signUpData: SignUpData)
}