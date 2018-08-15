package com.teste.clientapp.consume;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ServiceConsumer {
    private String ipAddress;
    private Double[] location = new Double[0];
    private int woeid;
    private int tempMax;
    private int tempMin;
    private Data ipData;

    private RestTemplate restTemplate = new RestTemplate();

//        setCity("São paulo");
//        setLocation(2222);
//        setTempMax(15);
//        setTempMin(20);



    public Data getIpData() {
        return ipData;
    }




    public ServiceConsumer(String ipAddress) {

        this.ipAddress = ipAddress;
        this.ipAddress = "187.122.5.173";

        retrieveipData();
        retrieveLocation();

    }

    private void retrieveLocation() {

        final String urlipdata = "https://ipvigilante.com/8.8.8.8";
        ResponseEntity<GeoLocation> geo = restTemplate.getForEntity(urlipdata, GeoLocation.class);

        location[2] = ipData.getLatitude();
        System.out.println(location[2] );
        //        location[1] = ipData.getLongitude();
//        System.out.println(location[0] +"maria"+location[1] );


    }

    private void retrieveipData() {

        final String urlipdata = "https://ipvigilante.com/";
        ResponseEntity<GeoLocation> geo = restTemplate.getForEntity(urlipdata+ipAddress, GeoLocation.class);
        ipData = geo.getBody().getData();

    }

    private void retrieveWeatherData() {

    }

//    static void main (String[] args){
//
//
//        String ip = ipAddress;
//        Double[] city = new Double[0];
//        Double  longitude;
//        Double latitude;
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<GeoLocation> geo = restTemplate.getForEntity(url + ip, GeoLocation.class);
//        System.out.println(geo.getBody().
//        getStatus());
//
//        Data data = geo.getBody().getData();
//        latitude = Double.parseDouble(data.getLatitude());
//        longitude = Double.parseDouble(data.getLongitude());
//        city[0] = latitude;
//        city[1] = longitude;
//
//        System.out.println(data.getContinent_name());
//
//        this.City = city;

}











