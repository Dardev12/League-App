package com.kmp.dardev.league.app.template.data.remote

import com.kmp.dardev.league.app.template.core.helper.NetworkCaller
import com.kmp.dardev.league.app.template.core.util.Constants
import com.kmp.dardev.league.app.template.domain.remote.IParameterAPI
import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult
import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.isSuccess

class ParameterAPI(private val networkCaller: NetworkCaller):IParameterAPI {
    private val client = HttpClient()

    override suspend fun deleteUser(userGuid:String,jwtToken: String): ValidateResult? {
        return networkCaller.executeSafeCall(client,"DELETE User",
            {
                url(Constants.sessionAPIUrl + "user/$userGuid")
                method = HttpMethod.Delete
                header(HttpHeaders.Authorization, "Bearer $jwtToken")
            },
            {response ->
                if (response.status.isSuccess()) {
                    ValidateResult(
                        successful = true
                    )
                } else {
                    ValidateResult(
                        successful = false,
                        errorString = "Error: ${response.status.description}"
                    )
                }
            }
        )
    }
}