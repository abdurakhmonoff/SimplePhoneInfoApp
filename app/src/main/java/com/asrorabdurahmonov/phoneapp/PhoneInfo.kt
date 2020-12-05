package com.asrorabdurahmonov.phoneapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asrorabdurahmonov.phoneapp.models.Phone
import com.asrorabdurahmonov.phoneapp.utils.MySharedPrefs
import kotlinx.android.synthetic.main.activity_phone_info.*

class PhoneInfo : AppCompatActivity() {
    private lateinit var phoneCurrent: Phone
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_info)

        val namePhone = intent.getStringExtra("SELECTED_PHONE_NAME")
        actionBar?.title = "$namePhone"
        supportActionBar?.title = "$namePhone"
        val allPhones = MySharedPrefs(this).getPhonesInfo()
        allPhones.forEach { if (namePhone == it.name) phoneCurrent = it }

        phone_features_txt.text = phoneCurrent.features
    }
}