package com.jjmin.sunrinthon

import android.app.Activity
import com.jjmin.sunrinthon.data.NetworkModules
import com.jjmin.sunrinthon.kakao.KakaoSDKAdapter
import com.jjmin.sunrinthon.utils.SharedUtils
import com.kakao.auth.KakaoSDK
import org.koin.core.context.startKoin

class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        globalApplicationContext = this
        KakaoSDK.init(KakaoSDKAdapter())
        SharedUtils.init(this)
        startKoin {
            this@Application

            modules(
              NetworkModules.networkModules
            )
        }
    }

    companion object {
        @Volatile
        var globalApplicationContext: Application? = null
            private set
        // Activity가 올라올때마다 Activity의 onCreate에서 호출해줘야한다.
        @Volatile
        var currentActivity: Activity? = null
    }
}