package com.unisytech.ebuybook.ditest

import androidx.lifecycle.SavedStateHandle
import com.unisytech.ebuybook.ExampleInstrumentedTest
import com.unisytech.ebuybook.MainActivity
import com.unisytech.ebuybook.di.DaggerEBuyBookComponent
import com.unisytech.ebuybook.di.EBuyBookComponent
import dagger.Component
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher

/**
 * Created by ramesh on 08/07/23.
 */

@Component(modules = [EBuybookModuleTest::class])
interface EBuyBookComponentTest : EBuyBookComponent  {
    fun inject(exampleInstrumentedTest : ExampleInstrumentedTest)
    fun provideCoroutineDispatcherTest() : CoroutineDispatcher
}