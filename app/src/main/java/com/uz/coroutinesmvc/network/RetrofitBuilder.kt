package com.uz.coroutinesmvc.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Eldor Turgunov on 26.08.2022.
 * Coroutines mvc
 * eldorturgunov777@gmail.com
 */
class RetrofitBuilder {
    companion object{
        private val retrofit:Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Url.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api:Api by lazy {
            retrofit.create(Api::class.java)
        }
    }
}