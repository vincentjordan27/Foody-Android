package com.example.foody.bindingadapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import coil.load
import com.example.foody.R
import com.example.foody.models.Result
import com.example.foody.ui.fragments.recipes.RecipesFragment
import com.example.foody.ui.fragments.recipes.RecipesFragmentDirections
import org.jsoup.Jsoup
import java.lang.Exception

@BindingAdapter("onRecipeClickListener")
fun onRecipeClickListener(recipeRowLayout: ConstraintLayout, result: Result){
    recipeRowLayout.setOnClickListener {
        try {
            val action = RecipesFragmentDirections.actionRecipesFragmentToDetailActivity(result)
            recipeRowLayout.findNavController().navigate(action)
        }catch (e: Exception){
            Log.d("onRecipeClickListener", e.toString())
        }
    }
}

@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(imageView: ImageView, imageUrl: String) {
    imageView.load(imageUrl) {
        crossfade(600)
        error(R.drawable.ic_no_image)
    }
}

@BindingAdapter("setNumberOfLikes")
fun setNumberOfLikes(textView: TextView, likes: Int){
    textView.text = likes.toString()
}

@BindingAdapter("setNumberOfMinutes")
fun setNumberOfMinutes(textView: TextView, minutes: Int){
    textView.text = minutes.toString()
}

@BindingAdapter("applyVeganColor")
fun applyVeganColor(view: View, vegan: Boolean) {
    if(vegan){
        when(view){
            is TextView -> {
                view.setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.green
                    )
                )
            }
            is ImageView -> {
                view.setColorFilter(
                    ContextCompat.getColor(
                        view.context,
                        R.color.green
                    )
                )
            }
        }
    }
}

@BindingAdapter("parseHtml")
fun parseHtml(textView: TextView, descriptions: String?) {
    if (descriptions != null){
        val desc = Jsoup.parse(descriptions).text()
        textView.text = desc
    }
}