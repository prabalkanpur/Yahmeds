package com.yahmeds.healthcare.network

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yahmeds.healthcare.helper.Yahmed
import com.yahmeds.healthcare.utils.NetworkUrl
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object RetrofitHelper {
    private val gson: Gson =
        GsonBuilder().excludeFieldsWithoutExposeAnnotation().setLenient().create()

    @JvmStatic
    fun <S> createRetrofitService(serviceClass: Class<S>): S {
        return createService(serviceClass)
    }

    private fun <S> createService(serviceClass: Class<S>): S {
        return RetrofitObj.client.create(serviceClass)
    }

    private object RetrofitObj {

        val client: Retrofit = Retrofit.Builder()
            .baseUrl(NetworkUrl.BASEURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(

                    HttpManager.normalClient.newBuilder()
                        .callTimeout(30, TimeUnit.SECONDS)
                        .addInterceptor(interceptor)
                        .addInterceptor(ChuckerInterceptor(Yahmed.applicationContext()))
                        .build()
                /*else{
                    HttpManager.normalClient.newBuilder()
                        .callTimeout(30, TimeUnit.SECONDS)
                        .addInterceptor(interceptor)
                        .addInterceptor(UnauthorizedInterceptor())
                        .build()*/
               // }
            )
            .build()
    }

    internal class UnauthorizedInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val response: Response = chain.proceed(chain.request())
            if (response.code == 500) {
                // BasePreferencesManager.clearPref()
               /* val intent = Intent(Foldia.applicationContext(), Sign_In::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                Foldia.applicationContext().startActivity(intent)*/
            }
            return response
        }
    }

    private val interceptor = run {
        val httpLoggingInterceptor = okhttp3.logging.HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
        }
    }

}