package com.asrorabdurahmonov.phoneapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asrorabdurahmonov.phoneapp.utils.MyAdapter
import kotlinx.android.synthetic.main.activity_phone_types2.*
import kotlinx.android.synthetic.main.item.view.*

class PhoneTypes2 : AppCompatActivity() {
    private lateinit var phoneTypeNames: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_types2)
        phoneTypeNames = arrayListOf("iPhone", "Samsung", "Mi", "Sony", "Huawei", "Artel")

        gv1.adapter = MyAdapter(phoneTypeNames, R.layout.item2)

        gv1.setOnItemClickListener { _, view, _, _ ->
            val intent = Intent(this, PhoneModels::class.java)
            intent.putExtra("SELECTED_TYPE", view.item_txt.text.toString())
            startActivity(intent)
        }
    }
}