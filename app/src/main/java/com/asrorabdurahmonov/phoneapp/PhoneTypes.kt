package com.asrorabdurahmonov.phoneapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_phone_types.*
import kotlinx.android.synthetic.main.item.view.*

class PhoneTypes : AppCompatActivity() {
    private lateinit var phoneTypeNames: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_types)
        phoneTypeNames = arrayListOf("iPhone", "Samsung", "Mi", "Sony", "Huawei", "Artel")

        lv1.adapter = MyAdapter(phoneTypeNames, R.layout.item)

        lv1.setOnItemClickListener { _, view, _, _ ->
            val intent = Intent(this, AddPhoneInfo::class.java)
            intent.putExtra("PHONE_TYPE", view.item_txt.text.toString())
            startActivity(intent)
        }
    }
}