package com.yahmeds.healthcare.helper

import android.app.Application
import android.content.Context
import com.yahmeds.healthcare.network.HttpManager

class Yahmed : Application(){
    var mInstance: Yahmed? = null
    var mContext: Context? = null

    init {
        instance = this
    }


    companion object {
        lateinit var instance: Yahmed
            private set
        var isAppRunning = false
        lateinit var appContext: Context
        fun applicationContext() : Context {
            return instance.applicationContext!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        mContext = this
        instance = this
        appContext = this
        HttpManager.initialize(this)
    }

}