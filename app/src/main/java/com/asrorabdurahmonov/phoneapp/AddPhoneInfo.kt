package com.asrorabdurahmonov.phoneapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.asrorabdurahmonov.phoneapp.models.Phone
import com.asrorabdurahmonov.phoneapp.utils.MySharedPrefs
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
                    ((intent.getStringExtra("PHONE_TYPE")).toString()),
                    phoneName,
                    phoneFeatures
                )
                val allPhones = MySharedPrefs(this).getPhonesInfo()
                allPhones.add(phone)
                MySharedPrefs(this).savePhoneInfo(allPhones)
                Toast.makeText(this, "Phone successfully added!", Toast.LENGTH_SHORT).show()
                finish()
            } else Toast.makeText(this, "Please, fill all gaps!", Toast.LENGTH_SHORT).show()
        }

    }
}