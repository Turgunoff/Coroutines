package com.uz.coroutinesmvc.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uz.coroutinesmvc.model.Post
import com.uz.coroutinesmvc.repository.PostRepository
import kotlinx.coroutines.launch


/**
 * Created by Eldor Turgunov on 26.08.2022.
 * Coroutines mvc
 * eldorturgunov777@gmail.com
 */
class PostViewModel(private val postRepository: PostRepository) : ViewModel() {
    val myResponse: MutableLiveData<List<Post>> = MutableLiveData()
    fun getPost() {
        viewModelScope.launch {
            try {
                val response = postRepository.getPost()
                myResponse.value = response

            } catch (e: Exception) {
                Log.d("main", "getPost: ${e.message}")
            }
        }
    }
}