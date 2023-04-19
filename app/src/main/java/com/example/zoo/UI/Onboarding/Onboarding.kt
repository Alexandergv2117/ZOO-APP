package com.example.zoo.UI.Onboarding

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.zoo.R
import com.example.zoo.UI.MainActivity
import com.example.zoo.utils.Const.onboardingIIsView
import com.google.android.material.button.MaterialButton

class Onboarding : AppCompatActivity() {
    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
    private lateinit var indicatorsContainer: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        val actionBar = supportActionBar
        actionBar?.hide()
        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)
    }
    /*Informacion dentro del Item*/
    private fun setOnboardingItems() {
        val string1 = getString(R.string.desc1)
        val string2 = getString(R.string.desc2)
        val string3 = getString(R.string.desc3)
        val string4 = getString(R.string.desc4)
        val string5 = getString(R.string.desc5)
        onboardingItemsAdapter = OnboardingItemsAdapter(
            listOf(
                OnboardingItem(
                    onboardingImage = R.drawable.task,
                    title = "¡Bienvenido!",
                    description = string1
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.menu,
                    title = "¡Cooomencemos!",
                    description = string2
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.menudos,
                    title = "Sub-Menu",
                    description = string3
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.detalle,
                    title = "Detalle del Animal",
                    description = string4
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.comentario,
                    title = "Calificanos",
                    description = string5
                )
            )
        )
        /*Adapatación de Imagen al ViewPager2*/
        val onboardingViewPager = findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter = onboardingItemsAdapter
        onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
        findViewById<ImageView>(R.id.imageNext).setOnClickListener{
            if(onboardingViewPager.currentItem + 1 < onboardingItemsAdapter.itemCount){
                onboardingViewPager.currentItem++
            }else{
                /*navegar al activity principal*/
                NavigateToHomeActivity()
            }
        }
        findViewById<TextView>(R.id.textSkip).setOnClickListener{
            NavigateToHomeActivity()
        }
        findViewById<MaterialButton>(R.id.bottomNavigationView).setOnClickListener{
            NavigateToHomeActivity()
        }
    }
    private fun NavigateToHomeActivity(){
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("omboarding", "true")
        prefs.apply()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    /*Indicador de barras de navegacion*/
    private fun setupIndicators(){
        indicatorsContainer = findViewById(R.id.indicatorsContainer)
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams:LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i]= ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorsContainer.addView(it)


            }
        }
    }

    /*Indicador de navegacion actual*/
    private fun setCurrentIndicator(position:Int){
        val childCount = indicatorsContainer.childCount
        for(i in 0 until childCount){
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }
}