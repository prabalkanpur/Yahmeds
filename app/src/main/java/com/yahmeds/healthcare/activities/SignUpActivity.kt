package com.yahmeds.healthcare.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.AppCompatTextView
import com.yahmeds.healthcare.LoginActivity
import com.yahmeds.healthcare.R

class SignUpActivity : AppCompatActivity() {
    private lateinit var tv_signupp: AppCompatTextView
    private lateinit var btn_createAccount: Button
    private lateinit var spinnerUserType: AppCompatSpinner

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        tv_signupp = findViewById(R.id.tv_signupp)
        btn_createAccount = findViewById(R.id.btn_create_account)
        spinnerUserType = findViewById(R.id.spinner_user_type)
        tv_signupp.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })
        btn_createAccount.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "SignUp Successful.", Toast.LENGTH_LONG).show()
        })
        setUserTypeSpinner()
    }

    private fun setUserTypeSpinner() {
        val userType = resources.getStringArray(R.array.select_user_type)
        if (spinnerUserType != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, userType
            )
            spinnerUserType.adapter = adapter

            spinnerUserType.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@SignUpActivity,
                        "selected itam" + " " +
                                "" + userType[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }
}