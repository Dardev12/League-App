package com.kmp.dardev.league.app.template.domain.remote

import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult

interface IParameterAPI {
    suspend fun deleteUser(userGuid:String,jwtToken: String): ValidateResult?
}