package com.uz.coroutinesmvc.model


/**
 * Created by Eldor Turgunov on 26.08.2022.
 * Coroutines mvc
 * eldorturgunov777@gmail.com
 */
data class Post(
    val title: String,
    val body: String,
    var id: Int,
    val userId: Int
)