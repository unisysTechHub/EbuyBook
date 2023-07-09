package com.unisytech.ebuybook

import android.app.Application
import android.content.Context
import com.unisytech.ebuybook.di.DaggerEBuyBookComponent
import com.unisytech.ebuybook.di.EBuyBookComponent

/**
 * Created by ramesh on 16/3/22.
 */
open class EbuyApplication : Application() {
    open var appComponent: EBuyBookComponent? = null
    override fun onCreate() {
        super.onCreate()
        this.appComponent = DaggerEBuyBookComponent.create()
    }
}