package com.yahmeds.healthcare.network


import com.yahmeds.healthcare.utils.NetworkUrl.Companion.BASEURL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClass {
    companion object {
        var retrofit: Retrofit? = null
        val client: Retrofit
            get() {
                if (retrofit == null) {
                    val okHttpClient: OkHttpClient?
                   // var okHttpClient: OkHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient()
                   /* if (BuildConfig.CHUNK == "true") {
                        okHttpClient = OkHttpClient().newBuilder()
                            .addInterceptor(ChuckerInterceptor(Yahmed.applicationContext()))
                            .connectTimeout(60, TimeUnit.SECONDS)
                            .readTimeout(60, TimeUnit.SECONDS)
                            .build()
                    }else{*/
                        okHttpClient = OkHttpClient().newBuilder()
                            .connectTimeout(60, TimeUnit.SECONDS)
                            .readTimeout(60, TimeUnit.SECONDS)
                            .build()
                  //  }
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASEURL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit!!
            }
    }
}