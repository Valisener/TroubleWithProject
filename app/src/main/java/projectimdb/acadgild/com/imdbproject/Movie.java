package projectimdb.acadgild.com.imdbproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Movie {
//    int poster ;
    private String title = "Wolvy";
    String releaseDate = "1/2/2015";
    double popularity = 0;
    double rating;
    int voteCount ;
    Bitmap poster ;
//    Mipmap

    RVAdapter adapter;


    //    Image
    String imagePath;

    //This wont display but better use it anyway
    int movieId;
    //will need this
    String overview;




    public Bitmap getPoster() {
        return poster;
    }

    public void setPoster(Bitmap poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void loadImage() {
        if (imagePath != null && !imagePath.equals("")) {
            new GetImage().execute(imagePath);
        }
    }
    public void setAdapter(RVAdapter adapt){
        adapter = adapt;
    }

    public RVAdapter getAdapter() {
        return adapter;
    }

    private class GetImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                Bitmap image = ImageDownloader.getImage(urls[0].toString());
                return image;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null){
                poster = bitmap;
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
            else {
                Log.e("Error loading image", "Error in image file");
            }

        }
    }



}


