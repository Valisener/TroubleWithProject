package projectimdb.acadgild.com.imdbproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class MainActivity extends AppCompatActivity implements MovieUrls {
    TextView movie_title;
    String topRatedMoviesLink = "";
    private RecyclerView recyclerView;
//    Movie movies;
    ArrayList<Movie> arrayMovies = new ArrayList<>();
    RVAdapter rvAdapter;
    private ListView listView;
    GetMoviesList getMoviesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerview);

        getMoviesList = new GetMoviesList(MainActivity.this);

        try {
            arrayMovies = (ArrayList<Movie>) getMoviesList.execute(URLMOVIESUPCOMING).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }




//        Log.e("latest movies url",  URL);

//        for (int i = 0; i < arrayMovies.size();i++){
//            Log.e("Array " + i,  String.valueOf(arrayMovies.get(i).getRating()));
//        }
        for (Movie m: arrayMovies){
            m.loadImage();
        }

        //Create new adapter that hdnles the movies list
        rvAdapter = new RVAdapter(MainActivity.this,arrayMovies);




        //        Create a linearlayout manager with it being vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
//        Set the layout manager
        recyclerView.setLayoutManager(linearLayoutManager);


        recyclerView.setAdapter(rvAdapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.submenu_mostpopular:
                loadMovies(URLMOVIESPOPULAR);
                break;
            case R.id.submenu_upcoming:
                loadMovies(URLMOVIESUPCOMING);
                break;
            case R.id.submenu_latestmovies:
                loadMovies(URLMOVIESLATEST);
                break;
            case R.id.submenu_nowplaying:
                loadMovies(URLMOVIESNOWPLAYING);
                break;
            case R.id.submenu_toprated:
                loadMovies(URLMOVIESTOPRATED);
                break;



            case R.id.menu_refresh:
                rvAdapter.notifyDataSetChanged();
                break;


        }




        return true;
    }

    public void loadMovies(String url){
//        GetMoviesList getNewMoviesList = new GetMoviesList.execute(url).get();
        GetMoviesList newList= new GetMoviesList(MainActivity.this);
        try {
            arrayMovies = (ArrayList<Movie>) newList.execute(url).get();
            for (Movie m: arrayMovies){
                m.loadImage();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        rvAdapter = new RVAdapter(MainActivity.this,arrayMovies);
        recyclerView.setAdapter(rvAdapter);
        rvAdapter.notifyDataSetChanged();
    }


}
