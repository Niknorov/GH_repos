package com.example.icerock_t1.core

import android.app.Application
import com.example.icerock_t1.auth.di.authModule
import com.example.icerock_t1.core.di.networkModule
import com.example.icerock_t1.detail.di.readmeModule
import com.example.icerock_t1.repo.di.repositoriesModule
import com.example.icerock_t1.splash.di.splashModule
import com.example.icerock_t1.user.di.userModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                authModule,
                repositoriesModule,
                userModule,
                readmeModule,
                splashModule,
            )
        }
    }
}