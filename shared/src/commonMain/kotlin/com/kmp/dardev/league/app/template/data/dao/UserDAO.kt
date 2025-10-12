package com.kmp.dardev.league.app.template.data.dao


import com.kmp.dardev.league.app.template.data.local.dao.IUserDAO
import com.kmp.dardev.league.app.template.database.IdeaDB
import com.kmp.dardev.league.app.template.domain.model.User

class UserDAO(db: IdeaDB):IUserDAO {
    private val queries = db.landQueries

    override suspend fun getUserById(userId: String): User? {
        return queries.getUserById(userId)
            .executeAsOneOrNull()
            ?.toLandUser()
    }

    override suspend fun insertUser(user: User) {
        queries.insertUser(
            UserGuid = user.UserId,
            Email = user.Email,
            Picture = user.ProfilPicture,
        )
    }

    override suspend fun deleteUserById(userId:String) {
        queries.deleteUserById(userId)
    }
}