package com.home.androidiondemo2.common

import android.app.Application
import android.content.Context

class AIDApplication:Application() {

    init {
        appContext = this
    }

    companion object {
        lateinit var appContext: Context
    }
}