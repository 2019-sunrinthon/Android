package com.jjmin.sunrinthon.data

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModules {
    var url = "https://thon.iamking.me/"

    var retrifit =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build()
            .create(NetworkApi::class.java)

    val networkModules = module {
        single {
            retrifit
        }
    }

}