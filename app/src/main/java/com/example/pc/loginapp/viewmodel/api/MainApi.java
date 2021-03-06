package com.example.pc.loginapp.viewmodel.api;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pc.loginapp.R;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainApi extends AppCompatActivity {

    TextView txtuid;
    TextView txtid;
    TextView txttitle;
    TextView txtcomp;

    TextView tvWeatherJson;
    Button btnFetchWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apicall);


        txtuid=(TextView) findViewById(R.id.userid);
        txtid=(TextView) findViewById(R.id.idt);
        txttitle=(TextView) findViewById(R.id.titles);
        txtcomp=(TextView) findViewById(R.id.completed);


       // tvWeatherJson = (TextView) findViewById(R.id.tv_weather_json);
        btnFetchWeather = (Button) findViewById(R.id.btn_fetch_weather);
        btnFetchWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FetchWeatherData().execute();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private class FetchWeatherData extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // These two need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String forecastJsonStr = null;

            try {
                //Api call Url
                URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                forecastJsonStr = buffer.toString();
                return forecastJsonStr;
            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attemping
                // to parse it.
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("PlaceholderFragment", "Error closing stream", e);
                    }
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject=new JSONObject(s);
               String ud=jsonObject.getString("userId");
               txtuid.setText("UserId:" +ud);
              String idd=jsonObject.getString("id");
              txtid.setText("Id:" +idd);
              String titl=jsonObject.getString("title");
              txttitle.setText("Title:" +titl);
              String comp=jsonObject.getString("completed");
              txtcomp.setText("Completed:" +comp);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //tvWeatherJson.setText(s);
            Log.i("json", s);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

