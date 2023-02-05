package com.example.movies

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.movies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding?= null
    private val binding get() = _binding!!
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this
        navController = Navigation.findNavController(this, R.id.nav_host)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}