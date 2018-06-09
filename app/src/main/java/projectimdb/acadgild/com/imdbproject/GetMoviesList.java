package projectimdb.acadgild.com.imdbproject;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetMoviesList extends AsyncTask<String, Void, ArrayList<Movie>> {
    RVAdapter adapter;
    private ArrayList<Movie> movieArrayList = new ArrayList<>();
    private Context context;

    GetMoviesList(Context context){
        this.context = context;

    }



    @Override
    protected ArrayList<Movie> doInBackground(String... theUrl) {
        //image url
        String imageUrl = "https://image.tmdb.org/t/p/w185_and_h278_bestv2/";

//        HttpHandler sh = new HttpHandler();
        JsonFileHandler jsonFileHandler = new JsonFileHandler();
        //Define the url address to the api
        // wont use latest for now its not working right sooo use something else
//        String url = "http://api.themoviedb.org/3/movie/upcoming?api_key=f47dd4de64c6ef630c2b0d50a087cc33";


        //
        String jsonString = jsonFileHandler.getJsonFile(theUrl[0]);
        Log.e("Jimbo Starting loop", "");


        try {
            JSONObject jsonObj = new JSONObject(jsonString);
//            Context context = Get

            // Getting JSON Array node
            JSONArray results = jsonObj.getJSONArray("results");

            for (int i = 0; i < results.length();i++){
                String imagePath = "https://image.tmdb.org/t/p/w185_and_h278_bestv2";
                JSONObject theMovie = results.getJSONObject(i);
                String moviePosterPath = imagePath = imagePath + theMovie.getString("poster_path");
                int movieId = theMovie.getInt("id");
                String movieTitle = theMovie.getString("title") ;
                String movieReleasedDate = theMovie.getString("release_date");
                double moviePopularity = theMovie.getDouble("popularity");
                int movieVoteAverage = theMovie.getInt("vote_count");
                double movieRating = theMovie.getDouble("vote_average");
                Log.e("Movie is this: ", "" + movieTitle);
                Bitmap icon = BitmapFactory.decodeResource(context.getResources(),R.drawable.loading);



                Movie movie = new Movie();
                movie.setTitle(movieTitle);
                movie.setReleaseDate(movieReleasedDate);
                movie.setMovieId(movieId);
                movie.setVoteCount(movieVoteAverage);
                movie.setImagePath(moviePosterPath);
                movie.setPoster(icon);

//                movie.setPoster(Integer.valueOf("https://image.tmdb.org/t/p/w185_and_h278_bestv2" + moviePosterPath));
                movie.setRating(movieRating);
                Log.e("Movie vote is: ", "" + movie.getVoteCount());


                movieArrayList.add(movie);


            }



        } catch (JSONException e) {
            e.printStackTrace();
        }


        return movieArrayList;
    }


}
