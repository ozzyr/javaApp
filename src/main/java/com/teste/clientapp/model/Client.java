package com.teste.clientapp.model;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.Entity;

@Entity
@Qualifier("ClientRepo")

public class Client extends AbstractEntity {
    private String name;
    private Long id;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

