package com.bohra.movielist.repository;


import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bohra.movielist.response.MovieResponse;
import com.bohra.movielist.retrofit.ApiRequest;
import com.bohra.movielist.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//When we are using mvvm ,Main activity should receive these data, from the repository through a view model.
public class MovieRepository extends Application {

    //    To get the string value we need the application context. How can we get an instance of application to repository?
    //    We can create a constructor for this repository class.keeping application as a parameter. So, define an application instance.
    private Application application;

//    /* Now generate the constructor, selecting application as a parameter. */
//    public MovieRepository(Application application) {
//        this.application = application;
//    }

    private ApiRequest apiRequest;

    public MovieRepository(Application application) {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
        this.application = application;

        //Now, create a method to get all movies data as live data.
    }

    //Now, create a method to get all movies data as live data.
    public LiveData<MovieResponse> getMovies(String key) {

        //    To create live data with the movie objects we are going to use MutableLiveData class.
        final MutableLiveData<MovieResponse> movieResponseMutableLiveData = new MutableLiveData<>();



        apiRequest.getPopularMovies(key)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                        if (response.body() != null) {

                            movieResponseMutableLiveData.setValue(response.body());

                            Toast.makeText(application, "sucess", Toast.LENGTH_SHORT).show();

                        } else {    //https://developers.themoviedb.org/3/movies/get-popular-movies

                            //      Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

//                        Toast.makeText(context, "try again", Toast.LENGTH_SHORT).show();
//                        movieResponseMutableLiveData.setValue(null);
                    }
                });
        return movieResponseMutableLiveData;
    }
}
