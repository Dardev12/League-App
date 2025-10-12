package com.kmp.dardev.league.app.template.presentation.screen.auth.register

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.kmp.dardev.league.app.template.SharedRes
import com.kmp.dardev.league.app.template.cache.scheduleSessionRefresh
import com.kmp.dardev.league.app.template.cache.session.ISessionCache
import com.kmp.dardev.league.app.template.domain.model.SignUpData
import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult
import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val sessionCache: ISessionCache,
) : ViewModel() {
    fun verifyEmailField(value: String): ValidateResult = ValidateResult(true)

    fun verifyPasswordField(value: String): ValidateResult = ValidateResult(true)

    fun verifyRepeatPasswordField(
        value: String,
        repeatValue: String,
    ): ValidateResult = ValidateResult(true)

    suspend fun applySignUp(signUpData: SignUpData): StringResource {
        /*val token = authSignUpService.createAccountLand(signUpData)
        val session = token?.let {
            Session(
                signUpData.email,
                dataUser = it
            )
        }
        if (session != null) {
            sessionCache.saveSession(
                session = session
            )
            return SharedRes.strings.enroll_success_message
        } else {*/
        return SharedRes.strings.enroll_error_validation_message
        // }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun automateWorker(context: Context) {
        scheduleSessionRefresh(sessionCache, context)
    }

    fun handleSignUpResult(task: Task<GoogleSignInAccount>) {
        try {
            val account = task.getResult(ApiException::class.java)
            val idToken = account.id ?: ""
            val email = account.email ?: ""
            val fullName = (account.givenName + account.familyName)
            // val url = account.photoUrl.toString() ?: ""
            val userName = account.displayName ?: ""

            viewModelScope.launch {
                /*val token = authSignUpGoogleService.createAccountGoogleLand(
                    LandSignUpGoogleData(
                        id = idToken,
                        email = email,
                        fullName = fullName,
                        username = userName,
                        photoUrl = "",
                        token = "",
                        IsPrivate = true
                    )
                )

                val session = token?.let {
                    Session(
                        email,
                        dataUser = it
                    )
                }
                if (session != null) {
                    sessionCache.saveSession(
                        session = session
                    )
                }*/
            }
        } catch (e: ApiException) {
            Log.e("Google Sign-In", "Failed: ${e.statusCode}")
        }
    }
}
