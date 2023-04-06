package com.example.zoo.UI.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.R

class OnboardigItemsAdapter(private val onboardingItems: List<OnboardingItem>):
RecyclerView.Adapter<OnboardigItemsAdapter.OnboardingItemViewHolder>(){

    inner class OnboardingItemViewHolder(view:View): RecyclerView.ViewHolder(view){
        private val imageOnboarding =view.findViewById<ImageView>(R.id.imageOnboarding)
        private val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private val textDescription= view.findViewById<TextView>(R.id.textDescription)

        fun bind(onboardingItem: OnboardingItem){
            imageOnboarding.setImageResource(onboardingItem.onboardingImage)
            textTitle.text = onboardingItem.title
            textDescription.text = onboardingItem.description

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
return OnboardingItemViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.layout_onboarding_container,
        parent,
        false
    )
)
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onboardingItems[position])
    }

    override fun getItemCount(): Int {
        return onboardingItems.size
    }

}