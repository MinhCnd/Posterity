package com.example.posterity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.posterity.data.AppDatabase
import com.example.posterity.data.AppRepository
import com.example.posterity.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val activityScope = CoroutineScope(SupervisorJob())
    val database by lazy { AppDatabase.getDatabase(this, activityScope)}
    val repository by lazy { AppRepository(database.itemDao())}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
        supportActionBar?.hide()

        navHostFragment?.findNavController()?.let{
            navView.setupWithNavController(it)
        }
    }
}