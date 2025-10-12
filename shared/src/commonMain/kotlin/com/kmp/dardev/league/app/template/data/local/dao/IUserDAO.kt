package com.kmp.dardev.league.app.template.data.local.dao

import com.kmp.dardev.league.app.template.domain.model.User

interface IUserDAO {
    suspend fun getUserById(userId:String):User?
    suspend fun insertUser(user: User)
    suspend fun deleteUserById(userId:String)
}