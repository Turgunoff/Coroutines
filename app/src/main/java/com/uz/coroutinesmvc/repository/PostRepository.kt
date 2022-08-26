package com.uz.coroutinesmvc.repository

import com.uz.coroutinesmvc.model.Post
import com.uz.coroutinesmvc.network.RetrofitBuilder


/**
 * Created by Eldor Turgunov on 26.08.2022.
 * Coroutines mvc
 * eldorturgunov777@gmail.com
 */
class PostRepository {
    suspend fun getPost(): List<Post> = RetrofitBuilder.api.getAllPost()
}