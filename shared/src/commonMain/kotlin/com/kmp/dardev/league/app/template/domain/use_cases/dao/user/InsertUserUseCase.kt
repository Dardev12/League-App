package com.kmp.dardev.league.app.template.domain.use_cases.dao.user

import com.kmp.dardev.league.app.template.data.local.dao.IUserDAO
import com.kmp.dardev.league.app.template.domain.model.User

class InsertUserUseCase(
    private val dao : IUserDAO
) {
    suspend operator fun invoke(landUser: User){
        dao.insertUser(landUser)
    }
}