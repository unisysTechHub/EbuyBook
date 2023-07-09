package com.unisytech.ebuybook.ditest

import com.unisytech.ebuybook.repo.FakeBookRepo
import com.unisytech.ebuybook.repo.BooksRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

/**
 * Created by ramesh on 08/07/23.
 */

@Module open interface EbuyBookInterfaceModuleTest {
    @Binds
    fun booksRepo(repo : FakeBookRepo) : BooksRepository
}
@Module(includes = [EbuyBookInterfaceModuleTest::class])
class EBuybookModuleTest {

//    @Provides
//    fun provideLoginRetrofitService(): LoginRetrofitService {
//        // Whenever Dagger needs to provide an instance of type LoginRetrofitService,
//        // this code (the one inside the @Provides method) is run.
//        return Retrofit.Builder()
//            .baseUrl("https://example.com")
//            .build()
//            .create(LoginService::class.java)
//    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Provides
    fun provideCoroutineDispatcherTest() : CoroutineDispatcher = TestCoroutineDispatcher()
}