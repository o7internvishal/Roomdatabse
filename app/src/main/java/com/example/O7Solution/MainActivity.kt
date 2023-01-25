package com.example.O7Solution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.O7Solution.data.UserDatabase
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    lateinit var UserDao: UserDatabase
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var nav_view: NavigationView
    lateinit var toolbar:Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        UserDao = UserDatabase.getDatabase(this)

        drawerLayout = findViewById(R.id.drawerlayout)
        nav_view = findViewById(R.id.nav_view)
//        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(findViewById(R.id.toolbar))
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.idProfile -> Toast.makeText(
                    applicationContext,
                    "Select Profile Button",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.idFavorite -> Toast.makeText(
                    applicationContext,
                    "Select Favorite Button",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.idHelp -> Toast.makeText(
                    applicationContext,
                    "Select Help Button",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.idSetting -> Toast.makeText(
                    applicationContext,
                    "Select Setting Button",
                    Toast.LENGTH_SHORT
                ).show()

            }
            true

        }


    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

