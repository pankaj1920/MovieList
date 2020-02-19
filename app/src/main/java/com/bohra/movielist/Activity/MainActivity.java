package com.bohra.movielist.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.bohra.movielist.R;
import com.bohra.movielist.adapter.MovieAdapter;
import com.bohra.movielist.response.MovieResponse;
import com.bohra.movielist.response.Result;
import com.bohra.movielist.view_model.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MovieResponse> movieResponses;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    ArrayList<Result> resultArrayList = new ArrayList<>();
    //    In the main activity , first of all we should get and instance of the view model class. We can do that using ViewModelProviders.
    MainActivityViewModel mainActivityViewModel;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("TMDB Popular Movies Today");


        initialization();

        getPopularMovies();


    }

    private void initialization() {

        recyclerView = findViewById(R.id.movieRecyclerView);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        //setting the adapter
        movieAdapter = new MovieAdapter(MainActivity.this, resultArrayList);
        recyclerView.setAdapter(movieAdapter);

        //viewmodel
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

    }


    private void getPopularMovies() {

        mainActivityViewModel.getMovie().observe(this, new Observer<MovieResponse>() {
            @Override
            public void onChanged(MovieResponse movieResponse) {

                if (movieResponse != null) {

                    List<Result> results = movieResponse.getResults();
                    resultArrayList.addAll(results);
                    movieAdapter.notifyDataSetChanged();
                }
            }
        });

    }
}
