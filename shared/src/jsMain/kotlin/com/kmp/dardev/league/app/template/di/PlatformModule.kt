package com.kmp.dardev.league.app.template.di

import com.kmp.dardev.league.app.template.data.dao.UserDAO
import com.kmp.dardev.league.app.template.data.local.dao.IUserDAO
import com.kmp.dardev.league.app.template.domain.use_cases.dao.UserUseCasesDAO
import com.kmp.dardev.league.app.template.domain.use_cases.dao.user.DeleteUserByIdUseCase
import com.kmp.dardev.league.app.template.domain.use_cases.dao.user.GetUserByIdUseCase
import com.kmp.dardev.league.app.template.domain.use_cases.dao.user.InsertUserUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    //single { DatabaseDriverFactory(get()) }

    /*factory<IdeaDatabase> {
        IdeaDatabase(get<DatabaseDriverFactory>().createDriver())
    }*/

    // DAO
    factory<IUserDAO> { UserDAO(get()) }

    // Use Case
    factory {
        UserUseCasesDAO(
            DeleteUserByIdUseCase(get()),
            GetUserByIdUseCase(get()),
            InsertUserUseCase(get())
        )
    }
}