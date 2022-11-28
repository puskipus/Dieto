package com.example.dieto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dieto.Api.ApiConfig
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var searchView : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recipe = findViewById<RecyclerView>(R.id.recycler_main)

        searchView = findViewById(R.id.search_view)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                ApiConfig.getService().getRecipe(query).enqueue(object : Callback<RecipeResponse> {
                    override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                        if (response.isSuccessful) {
                            val responseCode = response.body()
                            println(responseCode)
                            val dataNews = responseCode?.hits
                            val newsAdapter = RecipeAdapter(dataNews)
                            recipe.apply {
                                layoutManager = LinearLayoutManager(this@MainActivity)
                                setHasFixedSize(true)
                                adapter = newsAdapter
                                newsAdapter.notifyDataSetChanged()
                            }
                        }
                    }

                    override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }

                })
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        ApiConfig.getService().getRecipe("chicken").enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                if (response.isSuccessful) {
                    val responseCode = response.body()
                    println(responseCode)
                    val dataNews = responseCode?.hits
                    val newsAdapter = RecipeAdapter(dataNews)
                    recipe.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        adapter = newsAdapter
                        newsAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

        val floatButton = findViewById<FloatingActionButton>(R.id.floatButton)
        floatButton.setOnClickListener {
            val intent = Intent(this, SavedRecipe::class.java)
            startActivity(intent)
        }
    }
}