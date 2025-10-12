package com.kmp.dardev.league.app.template.domain.use_cases.dao.user

import com.kmp.dardev.league.app.template.data.local.dao.IUserDAO

class DeleteUserByIdUseCase(
    private val dao : IUserDAO
) {
    suspend operator fun invoke(id:String){
        dao.deleteUserById(id)
    }
}