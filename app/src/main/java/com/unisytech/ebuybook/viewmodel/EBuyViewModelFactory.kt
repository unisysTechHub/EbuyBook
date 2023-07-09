package com.unisytech.ebuybook.viewmodel

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.unisytech.ebuybook.EbuyApplication
import javax.inject.Inject

/**
 * Created by ramesh on 09/07/23.
 */
class EBuyViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    @Inject
    lateinit var ebuyBooksListViewModel : EbuyBooksListViewModel

    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        try {
            if (modelClass.isAssignableFrom(EbuyBooksListViewModel::class.java)) {
                return ebuyBooksListViewModel as T
            }
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        }
        return modelClass.newInstance()
    }
}

