package com.example.zoo.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.zoo.R
import com.example.zoo.UI.Auth.LoginActivity
import com.example.zoo.UI.Onboarding.Onboarding
import com.example.zoo.databinding.ActivityMainBinding
import com.example.zoo.utils.Const.isLoggedIn
import com.example.zoo.utils.Const.onboardingIIsView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController


        omboardingIsReady()
        if (!onboardingIIsView) {
            val omboarding = Intent(this, Onboarding::class.java)
            startActivity(omboarding)
            finish()
        } else {
            session()
            if (!isLoggedIn) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Esto asegura que el usuario no pueda volver a MainActivity al presionar el botón Atrás
            } else {
                val appBarConfiguration = AppBarConfiguration(
                    setOf(
                        R.id.navigation_home, R.id.navigation_credits, R.id.navigation_comment
                    )
                )
                setupActionBarWithNavController(navController, appBarConfiguration)
                navView.setupWithNavController(navController)
            }
        }
    }

    private fun session() {
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val email = prefs.getString("email", null)
        val name = prefs.getString("name", null)

        isLoggedIn = email != null && name != null
    }

    private fun omboardingIsReady() {
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val onboarding = prefs.getString("omboarding", null)

        onboardingIIsView = onboarding != null
    }
}
