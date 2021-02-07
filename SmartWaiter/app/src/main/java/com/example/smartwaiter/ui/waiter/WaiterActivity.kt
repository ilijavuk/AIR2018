package com.example.smartwaiter.ui.waiter

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.smartwaiter.R
import kotlinx.android.synthetic.main.activity_restoran.*
import kotlinx.android.synthetic.main.activity_waiter.*
import kotlinx.android.synthetic.main.fragment_table_order.*

class WaiterActivity : AppCompatActivity() {


    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waiter)

        setUpNavigation()

        bottom_nav_waiter.setupWithNavController(navController)
        visibilityNavElements(navController)

    }

    private fun setUpNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_waiter) as NavHostFragment
        navController = navHostFragment.findNavController()

        setSupportActionBar(toolbarWaiter)
        setupActionBarWithNavController(navController)

        toolbarWaiter.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
    }

    private fun visibilityNavElements(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.tableOrderFragment -> bottom_nav_waiter?.visibility = View.GONE
                else -> bottom_nav_waiter?.visibility = View.VISIBLE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}