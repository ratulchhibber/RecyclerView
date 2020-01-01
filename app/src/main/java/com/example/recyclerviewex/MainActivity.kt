package com.example.recyclerviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blogAdapter: BlogRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        addDataSet()
    }

    private fun addDataSet() {
        val data = DataSource.createDataSet()
        blogAdapter.submitBlog(data)
    }

    private fun setupRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            blogAdapter = BlogRecyclerAdapter()
            adapter = blogAdapter
            val topItemSpacingDecoration = TopItemSpacingDecoration(30)
            addItemDecoration(topItemSpacingDecoration)
        }
    }
}
