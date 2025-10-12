package com.kmp.dardev.league.app.template.data.remote

import com.kmp.dardev.league.app.template.core.helper.NetworkCaller
import com.kmp.dardev.league.app.template.core.util.Constants
import com.kmp.dardev.league.app.template.domain.model.Post
import com.kmp.dardev.league.app.template.domain.remote.IPostAPI
import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult
import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.url
import io.ktor.content.TextContent
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.isSuccess
import io.ktor.util.InternalAPI

class PostAPI(private val networkCaller: NetworkCaller): IPostAPI {
    private val client = HttpClient()

    @OptIn(InternalAPI::class)
    override suspend fun postNewPost(post: Post, jwtToken: String): ValidateResult? {
        val jsonBody = """
            {
                "PostGUID": "v",
                "UserGUID": "${post.UserId}",
                "Picture": "${post.Picture}",
                "Description": "${post.Description}",
            }
        """.trimIndent()

        return networkCaller.executeSafeCall(client, "POST publish a Post",
            {
                url(Constants.sessionAPIUrl + "post/publish")
                method = HttpMethod.Post
                body = TextContent(jsonBody, ContentType.Application.Json)
                header(HttpHeaders.Authorization, "Bearer $jwtToken")
            },
            { response ->
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