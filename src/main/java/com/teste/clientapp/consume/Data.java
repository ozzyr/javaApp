package com.teste.clientapp.consume;

// classe para mapear /*classe binding para resgatar dados da api ipvigilante
public class Data {


    private Double latitude;
    private Double longitude;

    public Data(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public Data() {
    }


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}