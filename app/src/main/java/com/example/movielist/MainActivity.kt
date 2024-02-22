package com.example.movielist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = horizontalLayoutManager
        movieAdapter = MovieAdapter(emptyList())
        recyclerView.adapter = movieAdapter

        val apiService = RetrofitClient.getInstance().create(Api::class.java)

        GlobalScope.launch {
            try {
                val response: Response<ApiResponse> = apiService.getData()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        val apiResponse = response.body()
                        val movies = apiResponse?.results
                        if (!movies.isNullOrEmpty()) {
                            movieAdapter.setData(movies)
                            Log.i("Datas", movies.toString())
                        } else {
                            Log.e("Error", "No movies found")
                        }
                    } else {
                        Log.e(
                            "Error",
                            "Response unsuccessful: ${response.code()} - ${response.message()}"
                        )
                    }
                }
            } catch (e: Exception) {
                Log.e("Error", "Exception: ${e.message}", e)
            }
        }
    }
}
