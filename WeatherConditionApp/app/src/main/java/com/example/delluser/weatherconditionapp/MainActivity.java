package com.example.delluser.weatherconditionapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemSelectedListener
{
    private ArrayList<WeatherInformation> data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise data - to do: read from web service
        data = new ArrayList<WeatherInformation> ();
        data.add(new WeatherInformation("Cork", 8, WeatherConditions.Sunny));
        data.add(new WeatherInformation("Dublin", 9, WeatherConditions.Sunny));
        data.add(new WeatherInformation("Galway", 10, WeatherConditions.Cloudy));
        data.add(new WeatherInformation("Limerick", 11, WeatherConditions.Rain));

        // initialise spinner with cities from data
        Spinner spinner = (Spinner) findViewById(R.id.citySpinner);
        List<String> cities = new ArrayList<String> ();
        for (int i = 0; i < data.size(); i++)
        {
            cities.add(data.get(i).GetCity());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // hook in handler for selections on spinner
        spinner.setOnItemSelectedListener(this);
    }


    // item on picker selected
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    {
        String city = parent.getItemAtPosition(pos).toString();
        TextView temperaturetv = (TextView) findViewById(R.id.temperatureTextView);
        ImageView conditionsiv = (ImageView) findViewById(R.id.conditionsImageView);

        // update UI i.e. temperature and conditions
        for (WeatherInformation w: data)
        {
            // icons are 256 x 256 pixels
            // look best on xxhdpi
            if (w.GetCity().equalsIgnoreCase(city))
            {
                temperaturetv.setText(w.GetTemperature() + " Celsius");

                if (w.GetConditions() == WeatherConditions.Sunny)
                {
                    conditionsiv.setImageResource(R.drawable.sunny);
                }
                else if (w.GetConditions() == WeatherConditions.Cloudy)
                {
                    conditionsiv.setImageResource(R.drawable.cloudy);
                }
                else if (w.GetConditions() == WeatherConditions.Rain)
                {
                    conditionsiv.setImageResource(R.drawable.rain);
                }
            }
        }
    }

    public void onNothingSelected(AdapterView<?> parent)
    {
        // Another interface callback
    }

}

