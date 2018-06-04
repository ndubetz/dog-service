package com.integrate.dogservice.rest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DogServiceTest {

    @Mock
    private DogRepository dogRepository;

    @Test
    public void createDog_usesRepositoryToCreateDog() {
        DogService dogService = new DogService(dogRepository);

        DogRecord dogRecordPassedIn = new DogRecord()
            .setAge(7)
            .setLegs(4)
            .setName("Gnarls Barkley");
        DogRecord dogRecord = new DogRecord()
            .setId(1L)
            .setAge(7)
            .setLegs(4)
            .setName("Gnarls Barkley");

        when(dogRepository.save(dogRecordPassedIn)).thenReturn(dogRecord);

        Dog dogToCreate = new Dog()
            .setAge(7)
            .setLegs(4)
            .setName("Gnarls Barkley");
        Dog expectedDog = new Dog()
            .setId(1)
            .setAge(7)
            .setLegs(4)
            .setName("Gnarls Barkley");

        Dog dog = dogService.createDog(dogToCreate);
        assertEquals(expectedDog, dog);
        verify(dogRepository).save(dogRecordPassedIn);
    }
}