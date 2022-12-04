package com.example.dieto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class SavedRecipe : AppCompatActivity() {
    private lateinit var dbref: DatabaseReference
    lateinit var recipeRecyclerView: RecyclerView
    lateinit var savedRecipeList : ArrayList<RecipeSaved>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_recipe)

        recipeRecyclerView = findViewById(R.id.recycler_saved_recipe)
        recipeRecyclerView.layoutManager = LinearLayoutManager(this)
        recipeRecyclerView.setHasFixedSize(true)

        savedRecipeList = arrayListOf<RecipeSaved>()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("Recipe")
        dbref.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (recipeSnapshot in snapshot.children) {
                        val recipe = recipeSnapshot.getValue(RecipeSaved::class.java)
                        savedRecipeList.add(recipe!!)
                    }

                    recipeRecyclerView.adapter = SavedRecipeAdapter(savedRecipeList){index -> deleteItem(index)}
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun deleteItem(index : Int) {
        if (::savedRecipeList.isInitialized && ::recipeRecyclerView.isInitialized) {
            savedRecipeList.removeAt(index)
        }
    }
}

