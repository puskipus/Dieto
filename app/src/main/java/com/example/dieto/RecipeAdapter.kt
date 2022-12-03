package com.example.dieto

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RecipeAdapter(val dataRecipe: List<HitsItem?>?) : RecyclerView.Adapter<RecipeAdapter.MyViewHolder>() {
    var database : DatabaseReference = FirebaseDatabase.getInstance().getReference("Recipe")

    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val imgNews = view.findViewById<ImageView>(R.id.img_headline)
        val title = view.findViewById<TextView>(R.id.text_title)
        val source = view.findViewById<TextView>(R.id.text_source)
        val save = view.findViewById<CheckBox>(R.id.checkBoxSaved)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = dataRecipe?.get(position)?.recipe?.label
        holder.source.text = dataRecipe?.get(position)?.recipe?.dietLabels
            .toString().replace("[", "").replace("]", "")

        Glide.with(holder.imgNews)
            .load(dataRecipe?.get(position)?.recipe?.image)
            .error(R.drawable.ic_launcher_background )
            .into(holder.imgNews)

        holder.itemView.setOnClickListener {
            val uri = dataRecipe?.get(position)?.recipe?.url
            if (uri != null) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse(uri))
                holder.itemView.context.startActivity(intent)
            }
        }

        holder.save.setOnCheckedChangeListener { checkBox, isChecked ->
            if (isChecked) {
                val data = RecipeSaved(dataRecipe?.get(position)?.recipe?.label, dataRecipe?.get(position)?.recipe?.dietLabels
                    .toString().replace("[", "").replace("]", ""), dataRecipe?.get(position)?.recipe?.image, dataRecipe?.get(position)?.recipe?.url ,"")
                database.child(dataRecipe?.get(position)?.recipe?.label.toString()).setValue(data)
            } else {
                database.child(dataRecipe?.get(position)?.recipe?.label.toString()).removeValue()
            }
        }
    }

    override fun getItemCount(): Int {
        if(dataRecipe != null) {
            return dataRecipe.size
        }
        return 0
    }
}
