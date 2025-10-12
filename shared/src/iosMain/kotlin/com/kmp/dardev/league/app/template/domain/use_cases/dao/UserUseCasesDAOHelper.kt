package com.kmp.dardev.league.app.template.domain.use_cases.dao

import com.kmp.dardev.league.app.template.domain.model.User
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UserUseCasesDAOHelper: KoinComponent {
    val usecase: UserUseCasesDAO by inject()

    suspend fun deleteUserById(userId: String) {
        usecase.deleteUserByIdUseCase.invoke(userId)
    }

    suspend fun getUserById(userId: String): User? {
        return usecase.getUserByIdUseCase.invoke(userId)
    }

    suspend fun insertUser(user: User) {
        usecase.insertUserUseCase.invoke(user)
    }
}