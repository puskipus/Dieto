package com.example.dieto

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecipeAdapter(val dataNews: List<HitsItem?>?) : RecyclerView.Adapter<RecipeAdapter.MyViewHolder>() {
    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val imgNews = view.findViewById<ImageView>(R.id.img_headline)
        val title = view.findViewById<TextView>(R.id.text_title)
        val source = view.findViewById<TextView>(R.id.text_source)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = dataNews?.get(position)?.recipe?.label
        holder.source.text = dataNews?.get(position)?.recipe?.dietLabels
            .toString().replace("[", "").replace("]", "")

        Glide.with(holder.imgNews)
            .load(dataNews?.get(position)?.recipe?.image)
            .error(R.drawable.ic_launcher_background )
            .into(holder.imgNews)

        holder.itemView.setOnClickListener {
            val uri = dataNews?.get(position)?.recipe?.url
            if (uri != null) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse(uri))
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        if(dataNews != null) {
            return dataNews.size
        }
        return 0
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    init {
        view.setOnClickListener {
            println("tes")
        }
    }
}