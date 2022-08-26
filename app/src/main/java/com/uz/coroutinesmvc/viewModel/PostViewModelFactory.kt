package com.uz.coroutinesmvc.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.uz.coroutinesmvc.repository.PostRepository


/**
 * Created by Eldor Turgunov on 26.08.2022.
 * Coroutines mvc
 * eldorturgunov777@gmail.com
 */
class PostViewModelFactory(private val postRepository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        PostViewModel(postRepository) as T
}