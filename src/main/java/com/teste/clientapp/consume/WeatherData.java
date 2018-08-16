package com.teste.clientapp.consume;


public class WeatherData {


    private double min_temp;
    private double max_temp;

    public WeatherData() {
    }

    public WeatherData(double min_temp, double max_temp) {
        this.min_temp = min_temp;
        this.max_temp = max_temp;
    }

    public double getMin_temp() {
        return min_temp;
    }


    public double getMax_temp() {
        return max_temp;
    }


}


//
//    private int id;
//    weather_state_name;
//            weather_state_abbr;
//            wind_direction_compass;
//            created;
//            applicable_date;
//            min_temp;
//            max_temp;
//            the_temp;
//            wind_speed;
//            wind_direction;
//            air_pressure;
//            humidity;
//            visibility;
//            predictability;