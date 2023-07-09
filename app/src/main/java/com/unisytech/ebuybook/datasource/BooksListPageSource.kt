package com.unisytech.ebuybook.datasource


import androidx.paging.PagingSource
import com.unisytech.ebuybook.repo.BooksRepository
import com.unisytech.ebuybook.repo.UTAPIResponse
import com.unisytech.ebuybook.network.response.BaseResponse
import com.unisytech.ebuybook.network.response.Book
import com.unisytech.ebuybook.network.response.BooksListApiResponse
import com.unisytech.ebuybook.network.response.LastEvaluatedKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by ramesh on 6/1/22.
 */


class PageKeyedBooksListPagingSource(
    private val searchString: String, private val booksRepo: BooksRepository
) : PagingSource<Int, Book>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Book> {
        // print(response.books?.get(0))
        return when (val response: UTAPIResponse = booksRepo.getBooksList(searchString, 30)) {
            is UTAPIResponse.Success ->
                LoadResult.Page(
                    (response.value as BooksListApiResponse).books as List<Book>,
                    null,
                    null
                )
            is UTAPIResponse.Error -> LoadResult.Error(throwable = Throwable(response.baseResponse.message))
        }
    }
}
