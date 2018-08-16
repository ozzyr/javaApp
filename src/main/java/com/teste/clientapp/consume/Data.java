package com.teste.clientapp.consume;

// class para mapear retorno
public class Data {

//    private String ipv4;
//    private String continent_name;
//    private String country_name;
//    private String subdivision_1_name;
//    private String subdivision_2_name;
//    private String city_name;
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