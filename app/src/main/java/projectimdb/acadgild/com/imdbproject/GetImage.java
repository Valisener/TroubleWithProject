package projectimdb.acadgild.com.imdbproject;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.AsyncTask;

import java.net.URL;
import java.util.ArrayList;

public class GetImage extends AsyncTask<String, Void, Bitmap> {
    Bitmap image;
    GetImage (String url) {
        doInBackground(url);
    }
    GetImage(){

    }


    @Override
    protected Bitmap doInBackground(String... urls) {
        try {
         image = ImageDownloader.getImage(urls[0].toString());
        return image;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
    }

    public Bitmap getImage2(){
        return image;
    }
}
