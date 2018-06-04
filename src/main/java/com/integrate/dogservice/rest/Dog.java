package com.integrate.dogservice.rest;

import java.util.Objects;

public class Dog {

    private long id;
    private int legs;
    private String name;
    private int age;

    public static Dog fromRecord(DogRecord dogRecord) {
        return new Dog()
            .setId(dogRecord.getId())
            .setAge(dogRecord.getAge())
            .setLegs(dogRecord.getLegs())
            .setName(dogRecord.getName());
    }

    public Dog setId(long id) {
        this.id = id;
        return this;
    }

    public Dog setLegs(int legs) {
        this.legs = legs;
        return this;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public Dog setAge(int age) {
        this.age = age;
        return this;
    }

    public long getId() {
        return id;
    }

    public int getLegs() {
        return legs;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dog dog = (Dog) o;
        return id == dog.id &&
            legs == dog.legs &&
            age == dog.age &&
            Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, legs, name, age);
    }
}
