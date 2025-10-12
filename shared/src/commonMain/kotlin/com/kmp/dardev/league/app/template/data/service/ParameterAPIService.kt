package com.kmp.dardev.league.app.template.data.service

import com.kmp.dardev.league.app.template.domain.remote.IParameterAPI
import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult

class ParameterAPIService(
    private val parameterAPI: IParameterAPI
) {
    suspend fun removeAccount(userGuid:String,jwtToken: String): ValidateResult? {
        return parameterAPI.deleteUser(userGuid,jwtToken)
    }
}