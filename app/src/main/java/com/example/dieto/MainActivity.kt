package com.example.dieto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dieto.Api.ApiConfig
import com.google.android.material.floatingactionbutton.FloatingActionButton
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

//                    val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
//                    linearLayout.setOnClickListener {
//                        val openURL = Intent(android.content.Intent.ACTION_VIEW)
//                        openURL.data = Uri.parse(getUri())
//                    }

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