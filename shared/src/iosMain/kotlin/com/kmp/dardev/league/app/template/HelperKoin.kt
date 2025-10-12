package com.kmp.dardev.league.app.template

import com.kmp.dardev.league.app.template.di.appModule
import com.kmp.dardev.league.app.template.domain.remote.IAuthAPI
import com.kmp.dardev.league.app.template.domain.remote.IParameterAPI
import com.kmp.dardev.league.app.template.domain.remote.IPostAPI
import com.kmp.dardev.league.app.template.domain.remote.IUserAPI
import com.kmp.dardev.league.app.template.domain.service.IFirebaseAuthService
import com.kmp.dardev.league.app.template.domain.service.IFirebasePostService
import com.kmp.dardev.league.app.template.domain.service.IFirebaseUserService
import com.kmp.dardev.league.app.template.domain.use_cases.dao.UserUseCasesDAO
import com.kmp.dardev.league.app.template.domain.use_cases.post.PostUseCases
import com.kmp.dardev.league.app.template.domain.use_cases.user.UserUseCases
import com.kmp.dardev.league.app.template.di.platformModule
import org.koin.core.context.startKoin

fun initKoin() {
    val koinApp = startKoin {
        modules(
            appModule(),
            platformModule()
        )
    }.koin

    koinApp.get<IFirebaseAuthService>()
    koinApp.get<IFirebaseUserService>()
    koinApp.get<IFirebasePostService>()

    koinApp.get<IAuthAPI>()
    koinApp.get<IUserAPI>()
    koinApp.get<IPostAPI>()
    koinApp.get<IParameterAPI>()

    koinApp.get<UserUseCases>()
    koinApp.get<PostUseCases>()
    koinApp.get<UserUseCasesDAO>()
}