package com.kmp.dardev.league.app.template.domain.use_cases.dao

import com.kmp.dardev.league.app.template.domain.use_cases.dao.user.DeleteUserByIdUseCase
import com.kmp.dardev.league.app.template.domain.use_cases.dao.user.GetUserByIdUseCase
import com.kmp.dardev.league.app.template.domain.use_cases.dao.user.InsertUserUseCase

data class UserUseCasesDAO (
    val deleteUserByIdUseCase: DeleteUserByIdUseCase,
    val getUserByIdUseCase: GetUserByIdUseCase,
    val insertUserUseCase: InsertUserUseCase
)