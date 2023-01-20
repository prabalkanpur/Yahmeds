package com.yahmeds.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    private lateinit var btn_next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_next = findViewById(R.id.btn_next)
        btn_next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DashBoardActivity::class.java)
            // start your next activity
            startActivity(intent)
        })
    }
}