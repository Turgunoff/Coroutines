package com.uz.coroutinesmvc.network

import com.uz.coroutinesmvc.model.Post
import retrofit2.http.GET


/**
 * Created by Eldor Turgunov on 26.08.2022.
 * Coroutines mvc
 * eldorturgunov777@gmail.com
 */
interface Api {
    @GET("posts")
    suspend fun getAllPost(): List<Post>
}