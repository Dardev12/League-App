package com.kmp.dardev.league.app.template.domain.service

import com.kmp.dardev.league.app.template.domain.model.Post

interface IFirebasePostService {
    suspend fun getAllPost(): List<Post>
    suspend fun getPostById(postId:String): Post
    suspend fun userLikeAPost(postId: String,userId: String)
    suspend fun userDislikeAPost(postId: String,userId: String)
    suspend fun saveNewPost(Post: Post)
}