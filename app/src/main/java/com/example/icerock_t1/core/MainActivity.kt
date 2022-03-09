package com.example.icerock_t1.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.icerock_t1.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}