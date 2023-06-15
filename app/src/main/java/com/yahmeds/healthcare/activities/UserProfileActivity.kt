package com.yahmeds.healthcare.activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import com.yahmeds.healthcare.R

class UserProfileActivity : AppCompatActivity() {

    private lateinit var userImage:ImageView
    val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var userProfileBinding: UserProfileActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        userImage = findViewById(R.id.profile_image)
        userImage.setOnClickListener(View.OnClickListener {
            dispatchTakePictureIntent()
        })
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            userImage.setImageBitmap(imageBitmap)
        }
    }
}