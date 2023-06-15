package com.yahmeds.healthcare.repository

import com.yahmeds.healthcare.dataclass.LoginModel
import com.yahmeds.healthcare.network.ApiInterface
import com.yahmeds.healthcare.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class LoginRepository(private val apiInterface: ApiInterface) {

    suspend fun LoginRequest(mobile :String,pwd:String): Resource<LoginModel> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiInterface.login(mobile,pwd)
                if (response.isSuccessful && response.body() != null) {
                    Resource.success(response.body() as LoginModel)
                } else {
                    Resource.error(response.message(), null)
                }
            } catch (e: Exception) {
                Resource.error(e.message, null)

            }
        }
    }
}