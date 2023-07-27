package com.unisytech.ebuybook.di

import com.unisytech.ebuybook.repo.BooksRepository
import com.unisytech.ebuybook.repo.DefaultBooksRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.reflect.KClass

/**
 * Created by ramesh on 16/3/22.
 */
@Module open interface EbuyBookInterfaceModule {
    @Binds
    fun booksRepo(repo : DefaultBooksRepository) : BooksRepository
}

@Module(includes = [EbuyBookInterfaceModule::class])
 class EBuybookModule {

//    @Provides
//    fun provideLoginRetrofitService(): LoginRetrofitService {
//        // Whenever Dagger needs to provide an instance of type LoginRetrofitService,
//        // this code (the one inside the @Provides method) is run.
//        return Retrofit.Builder()
//            .baseUrl("https://example.com")
//            .build()
//            .create(LoginService::class.java)
//    }



    @Provides
    fun provideCoroutineDispatcher() : CoroutineDispatcher = Dispatchers.Default
}