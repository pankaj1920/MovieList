package com.bohra.movielist.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {

    //https://developers.themoviedb.org/3/movies/get-popular-movies

    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.themoviedb.org";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
