package com.example.movielist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private var movies: List<Model>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.itemView.findViewById<TextView>(R.id.MovieName).text = movie.title
        val releaseYear = movie.release_date?.substring(0, 4)

        holder.itemView.findViewById<TextView>(R.id.Year).text = releaseYear


        val baseUrl = "http://image.tmdb.org/t/p/w780"
        val fullPosterPath = baseUrl + movie.backdrop_path
        Log.i("photo",fullPosterPath)

        Glide.with(holder.itemView.context)
            .load(fullPosterPath)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.error_image)
            .override(81, 81) // Set the desired width and height
            .into(holder.itemView.findViewById<ImageView>(R.id.Image))

    }

    override fun getItemCount(): Int {
        // Log the itemCount for debugging
        return movies.size
    }

    fun setData(newMovies: List<Model>?) {
        newMovies?.let {
            movies = it
            notifyDataSetChanged()
        }
    }
}
