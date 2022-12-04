package com.example.dieto

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
//import com.example.dieto.databinding.ActivitySavedRecipeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.dieto.RecipeAdapter

class SavedRecipeAdapter(private val savedRecipeList : ArrayList<RecipeSaved>, val onClickDelete: (Int) -> Unit) : RecyclerView.Adapter<SavedRecipeAdapter.MyViewHolder>() {
    var database : DatabaseReference = FirebaseDatabase.getInstance().getReference("Recipe")
    private var listData = savedRecipeList

//    private lateinit var binding: ActivitySavedRecipeBinding

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgNews = view.findViewById<ImageView>(R.id.img_headline)
        val title = view.findViewById<TextView>(R.id.text_title)
        val source = view.findViewById<TextView>(R.id.text_source)
        val delete = view.findViewById<ImageView>(R.id.btn_delete)
        val notes = view.findViewById<TextView>(R.id.text_notes_value)
        val update = view.findViewById<Button>(R.id.update_btn)

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
        holder.notes.text = currentItem?.notes

        Glide.with(holder.imgNews)
            .load(currentItem.image)
            .error(R.drawable.ic_launcher_background )
            .into(holder.imgNews)

        holder.delete.setOnClickListener {
            deleteItem(position)
            database.child(currentItem?.label.toString()).removeValue()

        }

        holder.update.setOnClickListener {
            updateItem(
                currentItem?.label.toString(),
                currentItem.dietLabels.toString(),
                currentItem.image.toString(),
                currentItem.url.toString(),
                holder.notes.text.toString()
            )
        }

        holder.itemView.setOnClickListener {
            val uri = currentItem?.url
            if (uri != null) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse(uri))
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    private fun deleteItem(position: Int) {
        listData.removeAt(position)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    private fun updateItem(label : String, dietLabels : String, image : String, url : String, notes : String) {
        val dbUpdt = FirebaseDatabase.getInstance().getReference("Recipe").child(label)
        val updtRecipe = RecipeSaved(label, dietLabels, image, url, notes)
        dbUpdt.setValue(updtRecipe)
    }
}