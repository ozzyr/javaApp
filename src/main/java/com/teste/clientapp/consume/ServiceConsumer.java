package com.teste.clientapp.consume;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

//private Date creatAt;
//private int tempMax;
//private int tempMin;


public class ServiceConsumer {
    private String ipAddress;
    private Double latitude;
    private Double longitude;
    private String city;
    private int woeid;
    private int tempMax;
    private int tempMin;
    private Data ipData;
    private Date createAt;

    private RestTemplate restTemplate = new RestTemplate();


    public Data getIpData() {
        return ipData;
    }

    public ServiceConsumer(String ipAddress) {

        this.ipAddress = ipAddress;
        this.ipAddress = "187.122.5.173";

        retrieveipData();
        retrieveLocation();

    }

    private void retrieveDistances(int[] distances, int[] woeids, String[] cities) {
        int shortd = Integer.MAX_VALUE;

        for (int i = 0; i < distances.length; i++) {
            if (distances[i] < shortd) {
                shortd = distances[i];
                woeid = woeids[i];
                city = cities[i];
            }
        }
        System.out.println(shortd);
        System.out.println(city);
        System.out.println(woeid);
    }


    private void retrieveLocation() {
        longitude = ipData.getLongitude();
        latitude = ipData.getLatitude();
        final String urlLocation = "https://www.metaweather.com/api/location/search/?lattlong="+latitude+","+longitude;
        System.out.println(urlLocation);
        int i = 0;
        ResponseEntity<LocationData[]> location = restTemplate.getForEntity(urlLocation, LocationData[].class);
        LocationData[] ld;

        ld = location.getBody();

        if (ld.length != 0) {
            int[] distances = new int[ld.length];
            String[] cities = new String[ld.length];
            int[] woeids = new int[ld.length];

            for (LocationData locationData : ld) {
                distances[i] = locationData.getDistance();
                cities[i] = locationData.getTitle();
                woeids[i] = locationData.getWoeid();
                i++;
            }
            retrieveDistances(distances, woeids, cities);
        }


    }

    private void retrieveipData() {

        final String urlipdata = "https://ipvigilante.com/";
        ResponseEntity<GeoLocation> geo = restTemplate.getForEntity(urlipdata + ipAddress, GeoLocation.class);
        ipData = geo.getBody().getData();

    }

    private void retrieveWeatherData() {
        final String urlLocation = "https://www.metaweather.com/api/location/search/?lattlong=-46.7833,-23.5667";


    }

    public Date getCreateAt() {
        return createAt;
    }

    public String getCity() {
        return city;
    }

    public int getWoeid() {
        return woeid;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }


}











