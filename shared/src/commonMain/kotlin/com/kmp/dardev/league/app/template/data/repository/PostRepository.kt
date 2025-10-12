package com.kmp.dardev.league.app.template.data.repository

import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult
import com.kmp.dardev.league.app.template.domain.use_cases.post.PostUseCases

class PostRepository(
    private val postUseCases: PostUseCases
) {
    fun verifyDescription(value: String): ValidateResult {
        return postUseCases.validateDescription.evoke(value)
    }
}