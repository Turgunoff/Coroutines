package com.uz.coroutinesmvc.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.uz.coroutinesmvc.adapter.PostAdapter
import com.uz.coroutinesmvc.databinding.ActivityMainBinding
import com.uz.coroutinesmvc.model.Post
import com.uz.coroutinesmvc.repository.PostRepository
import com.uz.coroutinesmvc.viewModel.PostViewModel
import com.uz.coroutinesmvc.viewModel.PostViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var postRepository: PostRepository
    private lateinit var postViewModelFactory: PostViewModelFactory
    private lateinit var postViewModel: PostViewModel
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

        postRepository = PostRepository()
        postViewModelFactory = PostViewModelFactory(postRepository)
        postViewModel = ViewModelProvider(this, postViewModelFactory)[PostViewModel::class.java]

        postViewModel.getPost()

        postViewModel.myResponse.observe(this) {
            postAdapter.setPostData(it as ArrayList<Post>)
            Log.d("main", it[0].title)
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        }
    }

    private fun initViews() {
        postAdapter = PostAdapter(this, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
    }
}