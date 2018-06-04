package com.integrate.dogservice.rest;

public class DogService {

    private DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog createDog(Dog dogToCreate) {
        DogRecord dogRecord = dogRepository.save(createDogRecord(dogToCreate));
        return Dog.fromRecord(dogRecord);
    }

    private DogRecord createDogRecord(Dog dogToCreate) {
        return new DogRecord()
            .setAge(dogToCreate.getAge())
            .setLegs(dogToCreate.getLegs())
            .setName(dogToCreate.getName());
    }
}
