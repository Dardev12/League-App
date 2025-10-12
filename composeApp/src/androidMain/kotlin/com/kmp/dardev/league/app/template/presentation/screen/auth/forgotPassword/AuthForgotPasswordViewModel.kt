package com.kmp.dardev.league.app.template.presentation.screen.auth.forgotPassword

import androidx.lifecycle.ViewModel
import com.kmp.dardev.league.app.template.SharedRes
import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult
import dev.icerock.moko.resources.StringResource

class AuthForgotPasswordViewModel : ViewModel() {
    fun verifyEmailField(value: String): ValidateResult = ValidateResult(true)

    suspend fun SendEmailToUser(email: String): StringResource = SharedRes.strings.connexion_success_message
}
