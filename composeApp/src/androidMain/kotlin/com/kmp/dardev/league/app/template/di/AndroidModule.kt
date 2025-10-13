package com.kmp.dardev.league.app.template.di

import android.content.Context
import android.content.SharedPreferences
import com.kmp.dardev.league.app.template.cache.session.ISessionCache
import com.kmp.dardev.league.app.template.cache.session.SessionCache
import com.kmp.dardev.league.app.template.presentation.screen.auth.forgotPassword.AuthForgotPasswordViewModel
import com.kmp.dardev.league.app.template.presentation.screen.auth.login.LoginViewModel
import com.kmp.dardev.league.app.template.presentation.screen.auth.register.RegisterViewModel
import com.kmp.dardev.league.app.template.presentation.screen.camera.CameraViewModel
import com.kmp.dardev.league.app.template.presentation.screen.home.HomeViewModel
import com.kmp.dardev.league.app.template.presentation.screen.onboarding.OnboardingViewModel
import com.kmp.dardev.league.app.template.presentation.screen.parameter.ParameterViewModel
import com.kmp.dardev.league.app.template.presentation.screen.profile.ProfileViewModel
import com.kmp.dardev.league.app.template.presentation.screen.splash.SplashViewModel
import com.kmp.dardev.league.app.template.service.analytics.AnalyticsHelper
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val androidModule =
    module {
        viewModelOf(::LoginViewModel)
        viewModelOf(::RegisterViewModel)
        viewModelOf(::AuthForgotPasswordViewModel)
        viewModelOf(::HomeViewModel)
        viewModelOf(::CameraViewModel)
        viewModelOf(::ProfileViewModel)
        viewModelOf(::ParameterViewModel)
        viewModelOf(::OnboardingViewModel)
        viewModelOf(::SplashViewModel)

        single<SharedPreferences> {
            androidContext().getSharedPreferences(
                "your_preference_name",
                Context.MODE_PRIVATE,
            )
        }
        single<ISessionCache> { SessionCache(get()) }
        single { AnalyticsHelper(get()) }
    }
