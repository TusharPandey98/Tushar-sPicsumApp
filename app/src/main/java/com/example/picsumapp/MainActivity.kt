package com.example.picsumapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.picsumapp.adapter.PostAdapter
import com.example.picsumapp.repository.Repository
import com.example.picsumapp.viewmodels.MainViewModel
import com.example.picsumapp.viewmodels.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val postAdapter by lazy { PostAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPosts()


        viewModel.myResponse.observe(this, { response ->
            if (response.isSuccessful) {
                response.body()?.let { postAdapter.setData(it) }
            } else {
                Log.d("MainActivity", response.code().toString())
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerView(){
        post_recyclerView.adapter = postAdapter
        post_recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

}