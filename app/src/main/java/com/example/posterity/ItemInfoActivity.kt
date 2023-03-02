package com.example.posterity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.posterity.data.AppDatabase
import com.example.posterity.data.AppRepository
import com.example.posterity.databinding.ActivityItemInfoBinding
import com.example.posterity.ui.itemInfo.ItemInfoViewModel
import kotlinx.coroutines.*

class ItemInfoActivity: AppCompatActivity() {

    private lateinit var binding : ActivityItemInfoBinding

    val activityScope = CoroutineScope(SupervisorJob())
    val database by lazy { AppDatabase.getDatabase(this, activityScope)}
    val repository by lazy { AppRepository(database.itemDao()) }

    private val viewModel: ItemInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intExtra = intent.getIntExtra("itemId",-1)

        //Launch a new coroutine on the IO dispatcher
        lifecycleScope.launch(Dispatchers.IO) {
            val item =  repository.loadById(intExtra)
            //Update View Model on the main thread
            withContext(Dispatchers.Main) {
                item?.let {
                    viewModel.setItem(it)
                    binding.toolbar.title = it.name
                }

            }
        }

        binding = ActivityItemInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }
}