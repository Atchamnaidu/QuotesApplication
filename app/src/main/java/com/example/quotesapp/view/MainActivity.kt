package com.example.quotesapp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotesapp.R
import com.example.quotesapp.databinding.ActivityMainBinding
import com.example.quotesapp.di.ViewModelFactory
import com.example.quotesapp.model.Response
import com.example.quotesapp.utils.SpacesItemDecoration
import com.example.quotesapp.viewmodel.MainViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: MainViewModel

    var adapter = QuotesAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)


        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)
//        binding =
//            DataBindingUtil.setContentView(this, R.layout.activity_main)
//
//        binding.lifecycleOwner = this
        //setContentView(binding.root)
        initRecyclerView()
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.quotes.observe(this) {
            when (it) {
                is Response.Success -> {
                    adapter.setData(it.data)
                }
                is Response.Error -> {
                    Log.e("Naidu", it.errorMsg + "")
                }
                is Response.Loading -> {}
            }
        }

        viewModel.getQuotes()
    }

    private fun initRecyclerView() {

        binding.rcQuotes.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcQuotes.addItemDecoration(SpacesItemDecoration(10))
        binding.rcQuotes.adapter = adapter
    }
}