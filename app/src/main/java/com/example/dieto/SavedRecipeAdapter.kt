package com.example.dieto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SavedRecipeAdapter(private val savedRecipeList : ArrayList<RecipeSaved>) : RecyclerView.Adapter<SavedRecipeAdapter.MyViewHolder>() {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgNews = view.findViewById<ImageView>(R.id.img_headline)
        val title = view.findViewById<TextView>(R.id.text_title)
        val source = view.findViewById<TextView>(R.id.text_source)
        val save = view.findViewById<CheckBox>(R.id.checkBoxSaved)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_recipe_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = savedRecipeList[position]

        holder.title.text = currentItem?.label
        holder.source.text = currentItem.dietLabels
            .toString().replace("[", "").replace("]", "")

        Glide.with(holder.imgNews)
            .load(currentItem.image)
            .error(R.drawable.ic_launcher_background )
            .into(holder.imgNews)
    }

    override fun getItemCount(): Int {
        return savedRecipeList.size
    }
}