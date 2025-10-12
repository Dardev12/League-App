package com.kmp.dardev.league.app.template.data.repository

import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PostRepositoryHelper : KoinComponent {
    private val repository: PostRepository by inject()

    fun verifyDescription(value: String): ValidateResult {
        return repository.verifyDescription(value)
    }
}