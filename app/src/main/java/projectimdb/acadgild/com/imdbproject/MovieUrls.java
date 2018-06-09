package projectimdb.acadgild.com.imdbproject;

public interface MovieUrls {
    String baseUrl = "http://api.themoviedb.org/3/movie/";
    String apiKey = "?api_key=8496be0b2149805afa458ab8ec27560c";
//    String apiKey = "?api_key=f47dd4de64c6ef630c2b0d50a087cc33";
//    String upcomingUrl = "http://api.themoviedb.org/3/movie/upcoming?api_key=" + apiKey;
    String latestText = "latest";
    String upcomingText = "upcoming";
    String nowPlayingText = "now_playing";
    String popularText = "popular";
    String topRatedText = "top_rated";



    final String URLMOVIESLATEST = baseUrl + latestText + apiKey;
    final String URLMOVIESUPCOMING= baseUrl + upcomingText + apiKey;
    final String URLMOVIESNOWPLAYING = baseUrl + nowPlayingText + apiKey;
    final String URLMOVIESPOPULAR = baseUrl + popularText + apiKey;
    final String URLMOVIESTOPRATED = baseUrl + topRatedText + apiKey;








}
