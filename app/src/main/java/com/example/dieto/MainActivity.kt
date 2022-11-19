package com.example.dieto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dieto.Api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val news = findViewById<RecyclerView>(R.id.recycler_main)

        ApiConfig.getService().getRecipe("chicken").enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                if (response.isSuccessful) {
                    val responseCode = response.body()
                    println(responseCode)
                    val dataNews = responseCode?.hits
                    val newsAdapter = RecipeAdapter(dataNews)
                    news.apply {
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
    }
}