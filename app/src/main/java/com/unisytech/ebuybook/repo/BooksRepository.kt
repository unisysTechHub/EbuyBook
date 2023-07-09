package com.unisytech.ebuybook.repo

import com.unisytech.ebuybook.network.BooksListAPI
import com.unisytech.ebuybook.network.response.BaseResponse
import com.unisytech.ebuybook.network.response.Book
import com.unisytech.ebuybook.network.response.BooksListApiResponse
import javax.inject.Inject

/**
 * Created by ramesh on 6/1/22.
 */
interface  BooksRepository{
    suspend fun getBooksList( searachString: String,  maxItems : Int) : UTAPIResponse

}
sealed class UTAPIResponse {
    class Success(val value : BaseResponse) : UTAPIResponse()
    class Error(val baseResponse: BaseResponse) : UTAPIResponse()
}

class DefaultBooksRepository @Inject constructor() : BooksRepository {
     private val booksListAPi by lazy {
         BooksListAPI.create()
     }

    override suspend fun getBooksList(searachString: String, maxItems: Int): UTAPIResponse {
        val requestbody = BooksListAPI.RequestBody(searachString, maxItems)
        val response = BaseResponse(statusCode = "200", message = "API call successfully ")
        return if (response.statusCode == "200") {
            UTAPIResponse.Success(
                BooksListApiResponse(
                    arrayListOf(
                        Book(),
                        Book(bookId = "Book2"),
                        Book(bookId = "Book6"),
                        Book(bookId = "Book3"),
                        Book(bookId = "Book4"),
                        Book(bookId = "Book5")
                    )
                )
            )
        } else UTAPIResponse.Error(response)
       //  return  booksListAPi().listOfBooks(APIHeadersBuilder.resourceHeaders(Endpoint.BooksListAPI) ,requestbody)
    }

    fun booksListAPi() = booksListAPi
}

