package com.example.zoo.UI.onboarding
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.zoo.UI.MainActivity
import com.example.zoo.R
import com.google.android.material.button.MaterialButton

class Onboarding : AppCompatActivity() {
 private lateinit var onboardingItemsAdapter: OnboardigItemsAdapter
 private lateinit var indicatorsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_onboarding)
        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)
    }




private fun setOnboardingItems() {
    onboardingItemsAdapter = OnboardigItemsAdapter(
        listOf(
            OnboardingItem(
                onboardingImage = R.drawable.task,
                title = "Descripción",
                description = "No importa si eres un entusiasta de la naturaleza  \n" +
                        "o simplemente un amante de los animales, nuestra aplicación \n " +
                        "móvil es fácil de usar y te mantendrá entretenido durante horas.\n " +
                        "Desde ranas vibrantes y camaleones coloridos hasta \n " +
                        "serpientes peligrosas y tortugas enigmáticas, ¡nuestro \n " +
                        "catálogo de Anfibios y Reptiles lo tiene todo!"
            ),
            OnboardingItem(
                onboardingImage = R.drawable.menuframe,
                title = "Menu Inicial",
                description = "Selecciona la especie"
            ),
            OnboardingItem(
                onboardingImage = R.drawable.submenu,
                title = "Menu Secundario",
                description = "Selecciona el animal de tu interes"
            ),
            OnboardingItem(
                onboardingImage = R.drawable.detalles,
                title = "Descripcion",
                description = "Disfruta aprendiendo y divirtiendote"
            ),
            OnboardingItem(
                onboardingImage = R.drawable.comentarios,
                title = "Comentarios",
                description = "Tambien puedes comentar y calificar para obtener una mejor experiencia"
            )
        )
    )
    val onboardingViewPager = findViewById<ViewPager2>(R.id.onboardinViewPager)
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
            onboardingViewPager.currentItem+=1
        }else{
            /*navegar al activity principal*/
            navigateToMainActivity()
        }
    }
    findViewById<TextView>(R.id.textSkip).setOnClickListener{
        navigateToMainActivity()
    }
    findViewById<MaterialButton>(R.id.bottomNavigationView).setOnClickListener{
        navigateToMainActivity()
    }

}

private fun navigateToMainActivity(){
    startActivity(Intent(applicationContext, MainActivity::class.java))
    finish()
}
    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams:LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
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
                indicatorsContainer = findViewById(R.id.indicatorContainer)

            }
        }
    }
    private fun setCurrentIndicator(position:Int){
        val childCount =indicatorsContainer.childCount
        for(i in 0 until childCount){
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if(i == position){
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
