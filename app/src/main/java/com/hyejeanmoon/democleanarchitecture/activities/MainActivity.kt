package com.hyejeanmoon.democleanarchitecture.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hyejeanmoon.democleanarchitecture.R

/**
 * top画面とdetail画面を表示するMain Activity
 */
class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)
        navController.navigate(R.id.topFragment)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    override fun onBackPressed() {
        //detail画面の時にはtop画面に戻り、top画面の時にはアプリを終了する
        if (navController.currentDestination?.id == R.id.topFragment) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}
