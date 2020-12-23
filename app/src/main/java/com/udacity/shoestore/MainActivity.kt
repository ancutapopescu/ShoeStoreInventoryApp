package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.ActivityMainBinding
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.models.ShoeListViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = this.findNavController((R.id.myNavHostFragment))
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupWithNavController(binding.toolbar, navController)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        Timber.plant(Timber.DebugTree())
    }

    override fun onNavigateUp(): Boolean {
        val navController = this.findNavController((R.id.myNavHostFragment))
        return navController.navigateUp()
    }



}
