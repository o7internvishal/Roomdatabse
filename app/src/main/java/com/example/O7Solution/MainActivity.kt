package com.example.O7Solution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.O7Solution.data.UserDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    lateinit var UserDao : UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         UserDao= UserDatabase.getDatabase(this)

        val navHostFragment=supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController=navHostFragment.navController
    }
}