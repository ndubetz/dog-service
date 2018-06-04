package com.integrate.dogservice.rest;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DogRecord {

    @Id
    @Column
    private Long id;

    @Column
    private int legs;

    @Column
    private String name;

    @Column
    private int age;

    public Long getId() {
        return id;
    }

    public DogRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public int getLegs() {
        return legs;
    }

    public DogRecord setLegs(int legs) {
        this.legs = legs;
        return this;
    }

    public String getName() {
        return name;
    }

    public DogRecord setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public DogRecord setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DogRecord dogRecord = (DogRecord) o;
        return legs == dogRecord.legs &&
            age == dogRecord.age &&
            Objects.equals(id, dogRecord.id) &&
            Objects.equals(name, dogRecord.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, legs, name, age);
    }
}
