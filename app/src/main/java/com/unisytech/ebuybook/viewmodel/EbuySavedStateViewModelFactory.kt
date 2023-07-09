package com.unisytech.ebuybook.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.unisytech.ebuybook.EbuyApplication
import javax.inject.Inject

/**
 * Created by ramesh on 09/07/23.
 */
class EbuySavedStateViewModelFactory(owner : SavedStateRegistryOwner, defaultArgs: Bundle?=null) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    init {
        ( (owner as ComponentActivity).applicationContext as EbuyApplication).appComponent?.inject(this)
    }
    @Inject
    lateinit var ebuyBooksListViewModel : EbuyBooksListViewModel
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
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