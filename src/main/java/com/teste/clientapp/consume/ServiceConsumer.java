package com.teste.clientapp.consume;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private double tempMax;
    private double tempMin;
    private Data ipData;
    private Date createAt;

    private RestTemplate restTemplate = new RestTemplate();


    public Data getIpData() {
        return ipData;
    }

    // construto da classe recebendo  o IP como parametro

    public ServiceConsumer(String ipAddress) {

        this.ipAddress = ipAddress;
        //this.ipAddress = "187.122.5.173";//teste ip externo

        retrieveDatafromIp();
        retrieveLocation();
        retrieveWeatherData();
    }
    // verifica no array de distancias qual a menor : mais próxima da passada.
    private void retrieveDistances(int[] distances, int[] woeids, String[] cities) {
        int shortd = Integer.MAX_VALUE;

        for (int i = 0; i < distances.length; i++) {
            if (distances[i] < shortd) {
                shortd = distances[i];
                woeid = woeids[i];
                city = cities[i];
            }
        }
    }
    // recupera dados do tempo apartir da localização por Lat e Long
    private void retrieveLocation() {
        longitude = ipData.getLongitude();
        latitude = ipData.getLatitude();
        final String urlLocation = "https://www.metaweather.com/api/location/search/?lattlong=" + latitude + "," + longitude;
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
    // retorna retonar latitude e longitude por ip
    private void retrieveDatafromIp() {

        final String urlipdata = "https://ipvigilante.com/" + ipAddress;
        ResponseEntity<GeoLocation> geo = restTemplate.getForEntity(urlipdata, GeoLocation.class);
        ipData = geo.getBody().getData();

    }
    // retorna informações do clima a partir de uma data e uma localidade WoeID (where on earth ID)
    private void retrieveWeatherData() {

        int i = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        createAt = date;
        final String urlweather = "https://www.metaweather.com/api/location/" + woeid + "/" + dateFormat.format(date);
        System.out.println(urlweather);
        System.out.println(dateFormat.format(date));

        ResponseEntity<WeatherData[]> weather = restTemplate.getForEntity(urlweather, WeatherData[].class);
        WeatherData[] wd;
        wd = weather.getBody();
        double[] tempMaxs = new double[wd.length];
        double[] tempMins = new double[wd.length];
        if (wd.length != 0) {

            for (WeatherData weatherData : wd) {
                tempMaxs[i] = weatherData.getMax_temp();
                tempMins[i] = weatherData.getMin_temp();
                i++;
            }
            retrieveTemperature(tempMaxs,tempMins);
        }

    }

// retorna min e max temperatura do array de temperaturas
    private void retrieveTemperature( double[] tmax, double[] tmin){

        double maxaux = Double.MIN_VALUE;
        double minaux = Double.MAX_VALUE;

        for (int i = 0; i < tmax.length; i++) {
            if (tmax[i] > maxaux) {
                maxaux = tmax[i];

            }
            tempMax = maxaux;
        }

        for (int y = 0; y < tmin.length; y++) {
            if (tmin[y] < minaux) {
                minaux = tmin[y];
                System.out.println(minaux);
            }
            tempMin = minaux;
        }

    }
// getters
    public Date getCreateAt() {
        return createAt;
    }

    public String getCity() {
        return city;
    }

    public int getWoeid() {
        return woeid;
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }


}











