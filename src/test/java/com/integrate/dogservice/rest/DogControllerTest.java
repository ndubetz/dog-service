package com.integrate.dogservice.rest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DogControllerTest {

    @Mock
    private DogService dogService;

    @Test
    public void createDog_usesServiceToCreateDog() {
        Dog dogPassedIn = new Dog()
            .setAge(3456)
            .setLegs(4)
            .setName("Kevin");
        Dog expectedDog = new Dog()
            .setId(1)
            .setAge(3456)
            .setLegs(4)
            .setName("Kevin");
        DogController dogController = new DogController(dogService);

        when(dogService.createDog(dogPassedIn))
            .thenReturn(expectedDog);

        Dog dog = dogController.createDog(dogPassedIn);

        assertEquals(expectedDog, dog);
        verify(dogService).createDog(dogPassedIn);
    }
}