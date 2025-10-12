package com.kmp.dardev.league.app.template.domain.use_cases.dao.user

import com.kmp.dardev.league.app.template.data.local.dao.IUserDAO
import com.kmp.dardev.league.app.template.domain.model.User

class GetUserByIdUseCase(
    private val dao : IUserDAO
) {
    suspend operator fun invoke(id:String):User?{
        return dao.getUserById(id)
    }
}