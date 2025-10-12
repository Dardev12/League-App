package com.kmp.dardev.league.app.template.domain.use_cases.user

import com.kmp.dardev.league.app.template.SharedRes
import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult

class ValidateUsername {
    fun evoke(username: String): ValidateResult {
        if (username.isBlank()) {
            return ValidateResult(
                successful = false,
                errorMessage = SharedRes.strings.validate_username_error_blank
            )
        }
        return ValidateResult(
            successful = true
        )
    }
}