package com.example.githubuserapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: UserAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter= UserAdapter()
        adapter.notifyDataSetChanged()
        viewModel=ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        binding.apply {
            rvUsersearch.layoutManager = LinearLayoutManager(this@MainActivity)
            rvUsersearch.setHasFixedSize(true)
            rvUsersearch.adapter=adapter

            btnSearch.setOnClickListener {

            }
            txtSearch.setOnKeyListener { v, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    searchUser()
                  return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }


        }
        viewModel.getSearchUsers().observe(this) {
            if (it != null) {
                adapter.setList(it)
            }
        }

    }

    private fun searchUser() {
binding.apply {
    val query = txtSearch.text.toString()
    if (query.isNotEmpty()) return
    viewModel.setSearchUsers(query)
}
    }

}