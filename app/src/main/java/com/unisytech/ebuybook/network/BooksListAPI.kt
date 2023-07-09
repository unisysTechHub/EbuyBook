package com.unisytech.ebuybook.network
import android.util.Log
import com.unisytech.ebuybook.network.response.BooksListApiResponse
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by ramesh on 5/1/22.
 */
const val baseURL = "https://w41v53pmwj.execute-api.us-east-1.amazonaws.com/default/"
interface BooksListAPI {

    @POST("EBuyBooksList")
  suspend  fun listOfBooks(@HeaderMap headers: Map<String,String>, @Body body: RequestBody) : BooksListApiResponse

    data class RequestBody(val serachString: String, val maxItems:Int)   {

    }


    companion object {
        private const val BASE_URL = "https://w41v53pmwj.execute-api.us-east-1.amazonaws.com/default/"
        fun create(): BooksListAPI {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Log.d("API", it) })
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()
            return Retrofit.Builder()
                    .baseUrl(HttpUrl.parse(BASE_URL)!!)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(BooksListAPI::class.java)
        }
    }
}