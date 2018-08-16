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
    private double tempMax;
    private double tempMin;

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

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }
}
