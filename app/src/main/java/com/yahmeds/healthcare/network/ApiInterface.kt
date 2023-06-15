package com.yahmeds.healthcare.network

import com.yahmeds.healthcare.dataclass.LoginModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiInterface {

    @POST("userlogin")
    suspend fun login(@Query("mobile") param1:String,
                      @Query("pwd")  param2:String): Response<LoginModel>

}