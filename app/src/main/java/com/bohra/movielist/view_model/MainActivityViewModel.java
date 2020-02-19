package com.bohra.movielist.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bohra.movielist.R;
import com.bohra.movielist.repository.MovieRepository;
import com.bohra.movielist.response.MovieResponse;

public class MainActivityViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;
    private LiveData<MovieResponse> movieResponseLiveData;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        movieRepository = new MovieRepository(application);
        //it will look like below line we are passing key form strimgs.xml file
        this.movieResponseLiveData = movieRepository.getMovies(application.getApplicationContext().getString(R.string.api_key));
//        this.movieResponseLiveData = movieRepository.getMovies("b133c1180758351bf9a6631f15a7457f");
    }

    public LiveData<MovieResponse> getMovie() {
        return movieResponseLiveData;
    }

}
