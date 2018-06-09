package projectimdb.acadgild.com.imdbproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{
//    variable that holds the context
    private Context context;
//    variable that holds the list of android versions
    ArrayList<Movie> movies;

//    Constructor
    public RVAdapter(Context context,ArrayList<Movie> movs){

        this.context = context;
        movies = movs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Create view with the custom layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null);
//        make a new viewholder with the view
        ViewHolder viewHolder = new ViewHolder(view);
//        return the viewholder
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Sets the text on the item in the viewholder

//        Bitmap picture;
        String postii = movies.get(position).getImagePath();
//        String PATH = "https://image.tmdb.org/t/p/w185_and_h278_bestv2/" + postii;
//        Bitmap imager = new GetImage().doInBackground(postii);
//        GetImage getImeg= new GetImage(postii);
//        getImeg.get();
//        holder.poster.setImageResource();
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.released.setText(movies.get(position).getReleaseDate());
//        holder.popularity.setText(movies.get(position).getPopularity());
        holder.rating.setText(String.valueOf(movies.get(position).getRating()));
        holder.userVoteCount.setText(String.valueOf(movies.get(position).getVoteCount()));
//        holder.poster.setImageBitmap(movies.get(position).getPoster());
//        arrayMovies = (ArrayList<Movie>) getLatestMovies.execute().get();
//        picture = imager.execute( movies.get(position).getImagePath()).get();

        if (movies.get(position).getPoster() != null){
            holder.poster.setImageBitmap(movies.get(position).getPoster());
        }
        else {
            holder.poster.setImageResource(R.drawable.loading);
        }

        movies.get(position).loadImage();
//        holder.pic.setImageBitmap(s.getImage())
        holder.poster.setImageBitmap(movies.get(position).getPoster());



//        movies.get(position).getPoster()
//        holder.path
//        new GetImage.execute((Bitmap) (movies.get(position).getImagePath()));
//        Get
//        GetImage.execute();
        ;
    }

    @Override
    public int getItemCount() {
//        returns the number of items in the list
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
//        initialize textview variable
        private ImageView poster;
        private TextView movieTitle;
        private ImageView popularity;
        private TextView released;
        private TextView rating;
        private TextView userVoteCount;
        private String path;

        public ViewHolder(View itemView) {
            super(itemView);
//            reference it to the id in the layout
            poster = itemView.findViewById(R.id.movie_image_modify);
            movieTitle = itemView.findViewById(R.id.movie_title_modify);
//            popularity = itemView.findViewById(R.id.movie_popularity_image_modify);
            released = itemView.findViewById(R.id.movie_released_date_modify);
            rating = itemView.findViewById(R.id.movie_rating_modify);
            userVoteCount = itemView.findViewById(R.id.movie_user_count_modify);





        }
    }
}