package com.dzak.puasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dzak.puasa.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val managefragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment? ?: return

        val navControler = managefragment.navController

        binding.bottomNavigationView.setupWithNavController(navControler)

    }
}