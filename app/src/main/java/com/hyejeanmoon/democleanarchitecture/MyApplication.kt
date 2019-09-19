package com.hyejeanmoon.democleanarchitecture

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * カスタマイズapplicationクラス
 */
class MyApplication : Application() {

    var context: Context? = null

    override fun onCreate() {
        super.onCreate()

        //frescoの初期化
        Fresco.initialize(this)
        //contextを取る為に
        context = applicationContext
    }


}