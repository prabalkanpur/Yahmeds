package com.yahmeds.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProvider
import com.yahmeds.healthcare.activities.SignUpActivity
import com.yahmeds.healthcare.network.ApiInterface
import com.yahmeds.healthcare.network.RetrofitHelper
import com.yahmeds.healthcare.repository.LoginRepository
import com.yahmeds.healthcare.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var btn_next: Button
    private lateinit var tv_signupp: AppCompatTextView
    private lateinit var viewModel: LoginViewModel
    private var mobile = "9953005190"
    private var pwd = "12345"
    private lateinit var tv_guest_login: AppCompatTextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
     init()
        viewModel = getViewModel()
        setObserver()
    }

    fun getViewModel():LoginViewModel{
        return ViewModelProvider(this,LoginViewModel.Factory(LoginRepository( RetrofitHelper.createRetrofitService(
            ApiInterface::class.java)))).get("",LoginViewModel::class.java)
    }
     fun setObserver(){
      viewModel.loginres.observe(this,{
          if (it.data!=null){
              Toast.makeText(this,"Login Successful.", Toast.LENGTH_LONG).show()
          }
      })
     }

    fun init(){
        btn_next = findViewById(R.id.btn_next)
        tv_signupp = findViewById(R.id.tv_signupp)
        tv_guest_login = findViewById(R.id.tv_guest_login)
        tv_guest_login.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DashBoardActivity::class.java)
            // start your next activity
            startActivity(intent)
            Toast.makeText(this,"Guest Login Successful.", Toast.LENGTH_LONG).show()
        })


        btn_next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DashBoardActivity::class.java)
            // start your next activity
            startActivity(intent)
            Toast.makeText(this,"Login Successful.", Toast.LENGTH_LONG).show()
           // viewModel.loginResponse("9953005190","12345")
        })
        tv_signupp.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        })
    }
    private fun requestApi(): HashMap<String,Any>{
        val json = HashMap<String,Any>()
        json["mobile"]="96554545454"
        json["pwd"]= "12345"
        return json
    }
}