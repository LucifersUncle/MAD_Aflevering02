package com.example.mad_aflevering01.API;
import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class WeatherApi {
    public WeatherApi(Context ctx)
    {
        context = ctx;
    }
    private Context context;

    public void getWeatherAPIDate(String city, String APIKey)
    {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + APIKey;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    Gson gson = new Gson();
                    OpenWeatherResponse weather = gson.fromJson(response, OpenWeatherResponse.class);
                    Toast.makeText(context, "Weather discription from Deserialized obj: " + weather.weather[0].description, Toast.LENGTH_LONG).show();
                },
                error -> Toast.makeText(context, "Error not working" + error.getMessage(),  Toast.LENGTH_LONG).show());
    queue.add(stringRequest);
    }
}