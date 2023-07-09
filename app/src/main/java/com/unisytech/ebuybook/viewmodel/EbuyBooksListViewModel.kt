package com.unisytech.ebuybook.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.unisytech.ebuybook.pager.BooksListPaging
import com.unisytech.ebuybook.repo.BooksRepository
import com.unisytech.ebuybook.network.response.Book
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by ramesh on 16/3/22.
 */

sealed class EBuyBooksListUiState {
    data class Success(val data: PagingData<Book>?= null): EBuyBooksListUiState()
    data class Error(val message: String): EBuyBooksListUiState()
    object IsLoading : EBuyBooksListUiState()
}

@OptIn(ExperimentalCoroutinesApi::class)
class EbuyBooksListViewModel @Inject constructor(
    val repo: BooksRepository,
    dispacther: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {
    private val clearListCh = Channel<Unit>(Channel.CONFLATED)
    private val _uiState: MutableStateFlow<EBuyBooksListUiState> = MutableStateFlow(
        EBuyBooksListUiState.Success(null)
    )
    val uiState: MutableStateFlow<EBuyBooksListUiState> = _uiState
    companion object {
        const val SEARCH_STRING = "BookName"
        const val DEFAULT_STRING = ""
    }
    init {
        viewModelScope.launch(context = dispacther) {
            Log.d("@Raesh", "onTest")
            BooksListPaging("it", 30, repo).pager()

                // cachedIn() shares the paging state across multiple consumers of posts,
                // e.g. different generations of UI across rotation config change
                .cachedIn(viewModelScope)
                .onStart { _uiState.value = EBuyBooksListUiState.IsLoading }
                .catch {
                    _uiState.value = EBuyBooksListUiState.Error(message = it.message ?: "")
                }
                .collect { _uiState.value = EBuyBooksListUiState.Success(data = it) }
        }
    }

//  suspend  fun getBooksList() {
//            Log.d("@Raesh", "onTest")
//            savedInstanceState!!.getLiveData<String>(SEARCH_STRING).asFlow().flatMapLatest {
//                BooksListPaging(it, 30, repo).pager()
//            }
//                // cachedIn() shares the paging state across multiple consumers of posts,
//                // e.g. different generations of UI across rotation config change
//                .cachedIn(viewModelScope)
//                .onStart { _uiState.value = EBuyBooksListUiState.isLoading }
//                .catch {
//                    _uiState.value = EBuyBooksListUiState.Error(message = it.message ?: "")
//                }
//                .collect {_uiState.value  = EBuyBooksListUiState.Success(data = it) }
//
//    }

//    val refreshWithSearchString = { searchString : String -> { savedInstanceState?.set(SEARCH_STRING, searchString)}}

}