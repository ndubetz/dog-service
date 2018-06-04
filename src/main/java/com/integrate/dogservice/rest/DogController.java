package com.integrate.dogservice.rest;

public class DogController {

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    public Dog createDog(Dog dogPassedIn) {
        return this.dogService.createDog(dogPassedIn);
    }
}
