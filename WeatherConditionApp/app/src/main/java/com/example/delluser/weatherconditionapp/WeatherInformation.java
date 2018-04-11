package com.example.delluser.weatherconditionapp;

/**
 * Created by Conor Griffin x00111602 on 11/04/2018.
 */

enum WeatherConditions {
    Cloudy, Sunny, Rain
}

// Weather information for a city,
public class WeatherInformation
{
    private String city;
    public String GetCity() { return city; };

    // Celsius
    private double temperature;
    public double GetTemperature() { return temperature; };

    private WeatherConditions conditions;
    public WeatherConditions GetConditions() { return conditions; };

    // constructor
    public WeatherInformation(String city, double temperature, WeatherConditions conditions)
    {
        // to do: validate inputs...
        this.city = city;
        this.temperature = temperature;
        this.conditions = conditions;
    }
}
