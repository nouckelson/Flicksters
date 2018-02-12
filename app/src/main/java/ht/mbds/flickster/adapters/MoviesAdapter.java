package ht.mbds.flickster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ht.mbds.flickster.R;
import ht.mbds.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Stephan on 2/11/2018.
 */

public class MoviesAdapter extends ArrayAdapter<Movie> {
    int orientation;
    public MoviesAdapter(Context context, List<Movie> movies, int orientation) {
        super(context, android.R.layout.simple_list_item_1,movies);
        this.orientation=orientation;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movie movie=getItem(position);

        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.item_movie,parent,false);
        }

        ImageView ivImage=(ImageView) convertView.findViewById(R.id.ivMovieImage);
        ivImage.setImageResource(0);

        TextView tvTitle=(TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview=(TextView) convertView.findViewById(R.id.tvOverView);

        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());
        if(orientation== Configuration.ORIENTATION_PORTRAIT)
            Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        else
            Picasso.with(getContext()).load(movie.getBackdropPath()).into(ivImage);
        return convertView;
    }
}
