package com.example.movielist

import retrofit2.Response
import retrofit2.http.GET



interface Api {
    @GET("/3/movie/upcoming?api_key=9c0523bff54071c4fb4b716a950231b9&language=en-US&page=1&region=IN%7CUS&with_release_type=2%7C3")
    suspend fun getData(): Response<ApiResponse>
}

