package projectimdb.acadgild.com.imdbproject;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class JsonFileHandler {


    public String getJsonFile(String requestUrl) {
        String response = null;
        try {
//            Log.e("request", "requestjson");
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //Tell it to use get when requesting the information
            connection.setRequestMethod("GET");
            //Read the connection response
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            //Convert the response to a string
            response = convertToString(inputStream);


            // catch exception
        } catch (MalformedURLException e) {
            e.printStackTrace();
            // catch exception
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    private String convertToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String sentence;

        try {
            while ((sentence = bufferedReader.readLine()) != null) {
                stringBuilder.append(sentence).append('\n');
            }
            // catch exception
        } catch (IOException e) {
            e.printStackTrace();
            }
            //close input stream
            finally {
            inputStream.close();;
        }
        // return the string builder as a string
        return stringBuilder.toString();
    }
}
