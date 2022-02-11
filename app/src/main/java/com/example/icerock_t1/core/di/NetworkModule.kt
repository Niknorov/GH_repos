package com.example.icerock_t1.core.di

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }

}

fun provideOkHttpClient(): OkHttpClient {

    val httpBuilder = OkHttpClient.Builder()
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    return httpBuilder.addInterceptor(httpLoggingInterceptor)
        .build()
}

fun provideRetrofit(
    okHttpClient: OkHttpClient
): Retrofit {

    val gson = GsonBuilder()
        .setLenient()
        .create()

    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .baseUrl("https://api.github.com")
        .build()
}