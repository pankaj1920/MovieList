package com.bohra.movielist.retrofit;

import com.bohra.movielist.response.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("/3/movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);

}
