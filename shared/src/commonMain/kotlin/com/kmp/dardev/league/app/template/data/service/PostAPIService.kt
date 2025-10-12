package com.kmp.dardev.league.app.template.data.service

import com.kmp.dardev.league.app.template.domain.model.Post
import com.kmp.dardev.league.app.template.domain.remote.IPostAPI
import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult

class PostAPIService(
    private val postAPI: IPostAPI
) {
    suspend fun createNewPost(post: Post, jwtToken: String): ValidateResult? {
        return postAPI.postNewPost(post, jwtToken)
    }

}