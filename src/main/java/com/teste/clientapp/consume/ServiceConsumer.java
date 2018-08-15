package com.teste.clientapp.consume;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class ServiceConsumer {
    private String ipAddress;
    private Double latitude;
    private Double longitude;
    private int woeid;
    private int tempMax;
    private int tempMin;
    private Data ipData;

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

    private void retrieveShortes(int[] distances, int[] woeids, String[] Cities) {

        System.out.println(Arrays.toString(distances));
        System.out.println(Arrays.toString(distances));
        System.out.println(Arrays.toString(distances));

    }


    private void retrieveLocation() {
        longitude = ipData.getLongitude();
        latitude = ipData.getLatitude();
        final String urlLocation = "https://www.metaweather.com/api/location/search/?lattlong=" + latitude + "," + longitude;
        int i = 0;
        ResponseEntity<LocationData[]> location = restTemplate.getForEntity(urlLocation, LocationData[].class);
        LocationData[] ld ;

        ld = location.getBody();

        if (ld.length != 0) {
            int distances[] = new int[ld.length];
            String cities[] = new String[ld.length];
            int woeids[] = new int[ld.length];

            for (LocationData locationData : ld) {
                distances[i] = locationData.getDistance();
                cities[i] = locationData.getTitle();
                woeids[i] = locationData.getWoeid();
                i++;
            }
            retrieveShortes(distances, woeids, cities);
        }




    }

    private void retrieveipData() {

        final String urlipdata = "https://ipvigilante.com/";
        ResponseEntity<GeoLocation> geo = restTemplate.getForEntity(urlipdata + ipAddress, GeoLocation.class);
        ipData = geo.getBody().getData();

    }

    private void retrieveWeatherData() {

    }


}











