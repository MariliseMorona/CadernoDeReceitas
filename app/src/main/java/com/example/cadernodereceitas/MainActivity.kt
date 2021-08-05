package com.example.cadernodereceitas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cadernodereceitas.databinding.ActivityMainBinding

abstract class MainActivity : AppCompatActivity() {

    abstract var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.include.toolbar

    }
}