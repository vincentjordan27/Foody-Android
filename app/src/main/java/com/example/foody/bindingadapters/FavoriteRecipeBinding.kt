package com.example.foody.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.adapters.FavoriteRecipesAdapter
import com.example.foody.data.database.entity.FavoritesEntity

@BindingAdapter("viewVisible", "setData", requireAll = false)
fun setDataAndViewVisibility(
    view: View,
    favoritesEntity: List<FavoritesEntity>?,
    mAdapter: FavoriteRecipesAdapter?
){
    if (favoritesEntity.isNullOrEmpty()){
        when(view){
            is ImageView -> {
                view.visibility = View.VISIBLE
            }
            is TextView -> {
                view.visibility = View.VISIBLE
            }
            is RecyclerView -> {
                view.visibility = View.INVISIBLE
            }
        }
    }else{
        when(view){
            is ImageView -> {
                view.visibility = View.INVISIBLE
            }
            is TextView -> {
                view.visibility = View.INVISIBLE
            }
            is RecyclerView -> {
                view.visibility = View.VISIBLE
                mAdapter?.setData(favoritesEntity)
            }
        }
    }
}