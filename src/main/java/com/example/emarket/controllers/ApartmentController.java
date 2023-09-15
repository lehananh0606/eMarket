package com.example.emarket.controllers;

import com.example.emarket.models.entities.Apartment;
import com.example.emarket.services.ApartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/apartment")
public class ApartmentController {

    private final ApartmentService apartmentService;
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping
    public List<Apartment> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @PostMapping
    public void addApartment(String address,
                             String rentalPrice,
                             Integer numberOfRooms
    ) {

        Apartment apartment = Apartment.builder()
                .address(address)
                .rentalPrice(rentalPrice)
                .numberOfRooms(numberOfRooms.shortValue())
                .build();

        apartmentService.addApartment(apartment);
    }
}
