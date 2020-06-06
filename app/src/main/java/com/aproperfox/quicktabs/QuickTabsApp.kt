package com.aproperfox.quicktabs

import android.app.Application
import com.aproperfox.quicktabs.db.AppDatabase
import com.aproperfox.quicktabs.di.AppComponent
import com.aproperfox.quicktabs.di.DaggerAppComponent

class QuickTabsApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        AppDatabase.instantiate(applicationContext)
        appComponent = DaggerAppComponent.create()
    }
}