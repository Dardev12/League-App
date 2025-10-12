package com.kmp.dardev.league.app.template.presentation.screen.auth.login

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
import com.kmp.dardev.league.app.template.domain.model.SignInData
import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult
import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.launch

class LoginViewModel(
    private val sessionCache: ISessionCache,
) : ViewModel() {
    fun verifyEmailField(value: String): ValidateResult = ValidateResult(true)

    fun verifyPasswordField(value: String): ValidateResult = ValidateResult(true)

    suspend fun applySignIn(signInData: SignInData): StringResource {
        /*val token = authSignInService.connectToLandAccount(signInData)
        val session = token?.let {
            Session(
                "",
                dataUser = it
            )
        }

        if (session != null) {
            sessionCache.saveSession(
                session = session
            )
            return SharedRes.strings.connexion_success_message
        } else {*/
        return SharedRes.strings.connexion_error_data_message
        // }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun automateWorker(context: Context) {
        scheduleSessionRefresh(sessionCache, context)
    }

    fun handleSignInResult(task: Task<GoogleSignInAccount>) {
        try {
            val account = task.getResult(ApiException::class.java)
            val idToken = account.id ?: ""
            val email = account.email ?: ""

            viewModelScope.launch {
                /*val token = authSignInGoogleService.connectToGoogleLandAccount(
                    LandSignInGoogleData(
                        id = idToken,
                        email = email,
                        token = ""
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
            Log.d("SEND THIS TO GO API", "Id: $account.id, Email: $account.email")
        } catch (e: ApiException) {
            Log.e("Google Sign-In", "Failed: ${e.statusCode}")
        }
    }
}
