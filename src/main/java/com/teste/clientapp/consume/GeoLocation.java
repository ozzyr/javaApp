
package com.teste.clientapp.consume;
/*classe binding para resgatar dados da api metaweather*/
public class GeoLocation {

    private String status;
    private Data data;

    public GeoLocation (){

    }

    public GeoLocation(String status, Data data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


}

