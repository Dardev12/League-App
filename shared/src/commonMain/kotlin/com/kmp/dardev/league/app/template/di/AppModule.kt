package com.kmp.dardev.league.app.template.di

import com.kmp.dardev.league.app.template.core.helper.NetworkCaller
import com.kmp.dardev.league.app.template.core.helper.NetworkCallerImpl
import com.kmp.dardev.league.app.template.data.remote.AuthAPI
import com.kmp.dardev.league.app.template.data.remote.ParameterAPI
import com.kmp.dardev.league.app.template.data.remote.PostAPI
import com.kmp.dardev.league.app.template.data.remote.UserAPI
import com.kmp.dardev.league.app.template.data.repository.PostRepository
import com.kmp.dardev.league.app.template.data.repository.UserRepository
import com.kmp.dardev.league.app.template.data.service.AuthAPIService
import com.kmp.dardev.league.app.template.data.service.ParameterAPIService
import com.kmp.dardev.league.app.template.data.service.PostAPIService
import com.kmp.dardev.league.app.template.data.service.UserAPIService
import com.kmp.dardev.league.app.template.data.service.firebase.FirebaseAuthService
import com.kmp.dardev.league.app.template.data.service.firebase.FirebasePostService
import com.kmp.dardev.league.app.template.data.service.firebase.FirebaseUserService
import com.kmp.dardev.league.app.template.domain.remote.IAuthAPI
import com.kmp.dardev.league.app.template.domain.service.IFirebaseAuthService
import com.kmp.dardev.league.app.template.domain.service.IFirebasePostService
import com.kmp.dardev.league.app.template.domain.service.IFirebaseUserService
import com.kmp.dardev.league.app.template.domain.remote.IParameterAPI
import com.kmp.dardev.league.app.template.domain.remote.IPostAPI
import com.kmp.dardev.league.app.template.domain.remote.IUserAPI
import com.kmp.dardev.league.app.template.domain.use_cases.ValidateResult
import com.kmp.dardev.league.app.template.domain.use_cases.post.PostUseCases
import com.kmp.dardev.league.app.template.domain.use_cases.post.ValidateDescription
import com.kmp.dardev.league.app.template.domain.use_cases.user.UserUseCases
import com.kmp.dardev.league.app.template.domain.use_cases.user.ValidateEmail
import com.kmp.dardev.league.app.template.domain.use_cases.user.ValidatePassword
import com.kmp.dardev.league.app.template.domain.use_cases.user.ValidateRepeatedPassword
import com.kmp.dardev.league.app.template.domain.use_cases.user.ValidateUsername
import io.ktor.client.HttpClient
import org.koin.dsl.module

fun appModule() = module {
    single<HttpClient> {
        HttpClient {
            // Configure your HttpClient here, including base URL, headers, and other settings.
        }
    }
    single<NetworkCaller> { NetworkCallerImpl(get()) }

    platformModule()

    // Firebase
    single<IFirebaseAuthService> { FirebaseAuthService() }
    single<IFirebaseUserService> { FirebaseUserService() }
    single<IFirebasePostService> { FirebasePostService() }

    // API
    single<IAuthAPI> { AuthAPI(get()) }
    single<IUserAPI> { UserAPI(get()) }
    single<IPostAPI> { PostAPI(get()) }
    single<IParameterAPI> { ParameterAPI(get()) }

    // Use Case
    single { UserUseCases(ValidateEmail(), ValidateUsername(), ValidatePassword(), ValidateRepeatedPassword(), ValidateResult(true)) }
    single { PostUseCases( ValidateDescription(), ValidateResult(true)) }

    // Repository
    factory { UserRepository(get()) }
    factory { PostRepository(get()) }

    // Service
    factory { AuthAPIService(get()) }
    factory { UserAPIService(get()) }
    factory { PostAPIService(get()) }
    factory { ParameterAPIService(get()) }


}