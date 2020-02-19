package com.bohra.movielist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bohra.movielist.R;
import com.bohra.movielist.response.MovieResponse;
import com.bohra.movielist.response.Result;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Result> resultArrayList;

    public MovieAdapter(Context context, ArrayList<Result> resultArrayList) {
        this.context = context;
        this.resultArrayList = resultArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Result result = resultArrayList.get(position);
        holder.movie_title.setText(result.getTitle());
        holder.movie_rating.setText(result.getReleaseDate());
        String posterPath = "https://image.tmdb.org/t/p/w500" + resultArrayList.get(position).getPosterPath();
        Glide.with(context).load(posterPath).into(holder.movie_poster);

    }

    @Override
    public int getItemCount() {
        return resultArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {


        public TextView movie_title, movie_rating;
        public ImageView movie_poster;

        public MovieViewHolder(View itemView) {
            super(itemView);

            movie_poster = (ImageView) itemView.findViewById(R.id.movie_poster);
            movie_rating = (TextView) itemView.findViewById(R.id.movie_rating);
            movie_title = (TextView) itemView.findViewById(R.id.movie_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        Toast.makeText(context, "dsd", Toast.LENGTH_SHORT).show();

                    }


                }
            });


        }
    }

}
