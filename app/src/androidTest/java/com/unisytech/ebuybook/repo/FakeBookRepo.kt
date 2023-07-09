package com.unisytech.ebuybook.repo

import com.unisytech.ebuybook.network.BooksListAPI
import com.unisytech.ebuybook.network.response.BaseResponse
import com.unisytech.ebuybook.network.response.Book
import com.unisytech.ebuybook.network.response.BooksListApiResponse
import javax.inject.Inject

/**
 * Created by ramesh on 08/07/23.
 */
class FakeBookRepo @Inject constructor() : BooksRepository {
    override suspend fun getBooksList(searachString: String, maxItems: Int): UTAPIResponse {
        val requestbody = BooksListAPI.RequestBody(searachString, maxItems)
        val response = BaseResponse(statusCode = "200", message = "API call successfully ")
        return if (response.statusCode == "200") {
            UTAPIResponse.Success(
                BooksListApiResponse(
                    arrayListOf(
                        Book(bookId = "BookTest")

                    )
                )
            )
        } else UTAPIResponse.Error(response)
    }
}
