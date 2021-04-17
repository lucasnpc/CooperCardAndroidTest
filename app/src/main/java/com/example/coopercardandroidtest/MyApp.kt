package com.example.coopercardandroidtest

import android.app.Application
import com.example.coopercardandroidtest.di.cardListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MyApp)

            modules(cardListModule)
        }
    }
}