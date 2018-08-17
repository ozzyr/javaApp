package com.teste.clientapp.consume;

/*classe binding para resgatar dados da api metaweather*/
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
