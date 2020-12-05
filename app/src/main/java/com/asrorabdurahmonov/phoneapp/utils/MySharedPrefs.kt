package com.asrorabdurahmonov.phoneapp.utils

import android.content.Context
import com.asrorabdurahmonov.phoneapp.models.Phone
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MySharedPrefs(context: Context) {

    private val sharedPrefs = context.getSharedPreferences("ALL_PHONES", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun savePhoneInfo(phones: ArrayList<Phone>) {
        val editor = sharedPrefs.edit()
        val phonesJson = gson.toJson(phones)
        editor.putString("ALL_PHONES_JSON", phonesJson)
        editor.apply()
    }

    fun getPhonesInfo(): ArrayList<Phone> {
        return if (sharedPrefs.contains("ALL_PHONES_JSON")) {
            val phonesJson = sharedPrefs.getString("ALL_PHONES_JSON", "")
            val type = object : TypeToken<ArrayList<Phone>>() {}.type
            val castArray = gson.fromJson<ArrayList<Phone>>(phonesJson, type)
            return castArray
        } else arrayListOf()
    }

}