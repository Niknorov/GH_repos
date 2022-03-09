package com.example.icerock_t1.user.data

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UserLocalDataSource @Inject constructor (@ApplicationContext context: Context) {

    private val masterKeyAlias = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()


    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "userName",
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
    )

    fun setUserName(userName: String) {

        sharedPreferences.edit()
            .putString("userName", userName)
            .apply()

    }

    fun getUserName(): String {

        return sharedPreferences.getString("userName", "").orEmpty()
    }

    fun clearUserName() {

        return sharedPreferences.edit { clear() }
    }
}