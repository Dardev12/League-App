package com.kmp.dardev.league.app.template.data.repository

import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UserRepositoryHelper: KoinComponent {
    private val repository: UserRepository by inject()

    fun scanEmailField(value: String): ValidateResult {
        return repository.scanEmailField(value)
    }

    fun scanUsernameField(value: String): ValidateResult {
        return repository.scanUsernameField(value)
    }

    fun scanPasswordField(value: String): ValidateResult {
        return repository.scanPasswordField(value)
    }

    fun scanRepeatPasswordField(value: String, repeatValue: String): ValidateResult {
        return repository.scanRepeatPasswordField(value, repeatValue)
    }
}