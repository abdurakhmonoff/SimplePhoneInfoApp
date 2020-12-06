package com.asrorabdurahmonov.phoneapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_phone_btn.setOnClickListener {
            val intent = Intent(this, PhoneTypes::class.java)
            startActivity(intent)
            finish()
        }

        phones_btn.setOnClickListener {
            val intent = Intent(this, PhoneTypes2::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}