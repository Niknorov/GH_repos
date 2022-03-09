package com.example.icerock_t1.splash.di

import com.example.icerock_t1.core.di.NetworkModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class SplashModule  {




}