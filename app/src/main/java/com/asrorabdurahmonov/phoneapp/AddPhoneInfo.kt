package com.asrorabdurahmonov.phoneapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_phone_info.*

class AddPhoneInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_phone_info)

        add_btn.setOnClickListener {
            val phoneName = phone_name_input.text.toString()
            val phoneFeatures = phone_features_input.text.toString()
            if (phoneFeatures != "" && phoneName != "") {
                val phone = Phone(
                    phoneName,
                    phoneFeatures,
                    (intent.getStringExtra("PHONE_TYPE")).toString()
                )
                val allPhones = MySharedPrefs(this).getPhonesInfo()
                allPhones.add(phone)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else Toast.makeText(this, "Please, fill all gaps!", Toast.LENGTH_SHORT).show()
        }

    }
}