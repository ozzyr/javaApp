package com.teste.clientapp.consume;


public class Data {

    private String ipv4;
    private String continent_name;
    private String country_name;
    private String subdivision_1_name;
    private String subdivision_2_name;
    private String city_name;
    private Double latitude;
    private Double longitude;

    public Data(String ipv4, String continent_name, String country_name, String subdivision_1_name, String subdivision_2_name, String city_name, Double latitude, Double longitude) {
        this.ipv4 = ipv4;
        this.continent_name = continent_name;
        this.country_name = country_name;
        this.subdivision_1_name = subdivision_1_name;
        this.subdivision_2_name = subdivision_2_name;
        this.city_name = city_name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Data() {
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getContinent_name() {
        return continent_name;
    }

    public void setContinent_name(String continent_name) {
        this.continent_name = continent_name;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getSubdivision_1_name() {
        return subdivision_1_name;
    }

    public void setSubdivision_1_name(String subdivision_1_name) {
        this.subdivision_1_name = subdivision_1_name;
    }

    public String getSubdivision_2_name() {
        return subdivision_2_name;
    }

    public void setSubdivision_2_name(String subdivision_2_name) {
        this.subdivision_2_name = subdivision_2_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
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
