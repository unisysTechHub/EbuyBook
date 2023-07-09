package com.unisytech.ebuybook.pager

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.unisytech.ebuybook.datasource.PageKeyedBooksListPagingSource
import com.unisytech.ebuybook.repo.BooksRepository

/**
 * Created by ramesh on 6/1/22.
 */
class BooksListPaging(private val searchString: String, private val pageSize : Int, private val repo : BooksRepository) {
    fun pager() = Pager(
    PagingConfig(pageSize)
    ) {
        PageKeyedBooksListPagingSource(searchString,
                booksRepo = repo
        )
    }.flow
}