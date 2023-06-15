package com.yahmeds.healthcare.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.yahmeds.healthcare.dataclass.LoginModel
import com.yahmeds.healthcare.network.Resource
import com.yahmeds.healthcare.repository.LoginRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class LoginViewModel(val loginRepository: LoginRepository) :ViewModel() {
    val error : MutableLiveData<String>?= null
    val loginres : MutableLiveData<LoginModel> by  lazy {
        MutableLiveData<LoginModel>()
    }
    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        handleError()
    }
     fun loginResponse(mobile :String,pwd:String){
      viewModelScope.launch(exceptionHandler){
          loginRepository.LoginRequest(mobile,pwd).let {
              when(it.status){
                  Resource.Status.SUCCESS->{
                      if (it.resData !=null){
                          loginResponseData(it.resData)
                          Log.d("prabal","pratap")
                      }
                  }
                  else -> {}
              }
          }
      }
    }
    private fun handleError(){
        error?.let {
            synchronized(it){
                error.postValue("")
            }
        }
    }

    private fun loginResponseData(loginModel: LoginModel){
        synchronized(loginres){
            loginres.postValue(loginModel)
        }
    }

    class Factory(private val loginRepository: LoginRepository):ViewModelProvider.NewInstanceFactory(){
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(loginRepository) as T
        }
    }


}