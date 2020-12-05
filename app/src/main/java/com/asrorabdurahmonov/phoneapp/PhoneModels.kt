package com.asrorabdurahmonov.phoneapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asrorabdurahmonov.phoneapp.utils.MyAdapter
import com.asrorabdurahmonov.phoneapp.utils.MySharedPrefs
import kotlinx.android.synthetic.main.activity_phone_models.*
import kotlinx.android.synthetic.main.item.view.*

class PhoneModels : AppCompatActivity() {
    lateinit var phoneModels: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_models)

        setModelsList()

        models_list.adapter = MyAdapter(phoneModels, R.layout.item)

        models_list.setOnItemClickListener { _, view, _, _ ->
            val intent = Intent(this, PhoneInfo::class.java)
            intent.putExtra("SELECTED_PHONE_NAME", view.item_txt.text.toString())
            startActivity(intent)
        }
    }

    private fun setModelsList() {
        phoneModels = arrayListOf()
        val allPhones = MySharedPrefs(this).getPhonesInfo()
        val selectedPhoneType = intent.getStringExtra("SELECTED_TYPE")
        actionBar?.title = "$selectedPhoneType"
        supportActionBar?.title = "$selectedPhoneType"
        val phones = allPhones.filter { it.type == selectedPhoneType }
        phones.forEach { phoneModels.add(it.name) }
    }
}