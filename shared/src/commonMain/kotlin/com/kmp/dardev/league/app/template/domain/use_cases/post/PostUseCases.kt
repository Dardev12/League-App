package com.kmp.dardev.league.app.template.domain.use_cases.post

import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult

data class PostUseCases(
    val validateDescription: ValidateDescription,
    val validateResult: ValidateResult
)
