package com.unisytech.ebuybook

import android.app.Application
import com.unisytech.ebuybook.di.EBuyBookComponent
import com.unisytech.ebuybook.ditest.DaggerEBuyBookComponentTest
import com.unisytech.ebuybook.ditest.EBuyBookComponentTest

/**
 * Created by ramesh on 08/07/23.
 */
class TestEBuyBookApplication : EbuyApplication() {
    override var appComponent : EBuyBookComponent? = null
    override fun onCreate() {
        super.onCreate()

        this.appComponent =  DaggerEBuyBookComponentTest.create()
    }
}