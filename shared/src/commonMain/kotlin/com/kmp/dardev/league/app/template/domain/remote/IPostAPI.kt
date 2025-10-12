package com.kmp.dardev.league.app.template.domain.remote

import com.kmp.dardev.league.app.template.domain.model.Post
import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult

interface IPostAPI {
    suspend fun postNewPost(post: Post, jwtToken: String): ValidateResult?
}