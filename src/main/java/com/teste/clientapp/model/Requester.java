package com.teste.clientapp.model;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Qualifier("RequesterRepo")

public class Requester extends AbstractEntity {

    private Long id;
    private Long userId;
    private int location;
    private String city;
    private Date creatAt;
    private int tempMax;
    private int tempMin;

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }


}
