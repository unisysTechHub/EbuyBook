package com.unisytech.ebuybook

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unisytech.ebuybook.pager.BooksListPagingAdapter
import com.unisytech.ebuybook.viewmodel.EBuyBooksListUiState
import com.unisytech.ebuybook.viewmodel.EBuyViewModelFactory
import com.unisytech.ebuybook.viewmodel.EbuyBooksListViewModel
import com.unisytech.ebuybook.viewmodel.EbuySavedStateViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var eBuyViewModelFactory: EBuyViewModelFactory
    val adapter = BooksListPagingAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (this.applicationContext as EbuyApplication).appComponent?.inject(this)
        var recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter;
        recyclerView.layoutManager = LinearLayoutManager(this);
        initAdapter()
    }
   // val viewModel: EbuyBooksListViewModel by viewModels{ eBuyViewModelFactory }
    val viewModel: EbuyBooksListViewModel by viewModels{ EbuySavedStateViewModelFactory(this) }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun initAdapter() {
        MainScope().launch {
            viewModel.uiState.collect(this@MainActivity::updateUI)
        }
    }
   private suspend fun updateUI(state : EBuyBooksListUiState) {
        when(state) {
            is EBuyBooksListUiState.IsLoading -> { print(" is loading ")
            }
            is EBuyBooksListUiState.Success -> { state.data?.let {adapter.submitData(it) }  }
            is EBuyBooksListUiState.Error -> { print("show Alet message")
            }
        }
    }
}

