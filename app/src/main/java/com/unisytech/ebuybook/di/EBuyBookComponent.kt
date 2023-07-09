package com.unisytech.ebuybook.di

import androidx.lifecycle.SavedStateHandle
import com.unisytech.ebuybook.MainActivity
import com.unisytech.ebuybook.viewmodel.EbuySavedStateViewModelFactory
import dagger.Component
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by ramesh on 16/3/22.
 */
@Component(modules = [EBuybookModule::class])
interface EBuyBookComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(ebuySavedStateViewModelFactory: EbuySavedStateViewModelFactory)
    fun provideCoroutineDispatcher() : CoroutineDispatcher
}