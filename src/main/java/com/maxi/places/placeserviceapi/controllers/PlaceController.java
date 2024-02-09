package com.maxi.places.placeserviceapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.places.placeserviceapi.dtos.PlaceRequestDTO;
import com.maxi.places.placeserviceapi.services.PlaceServiceImplementation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/places")
public class PlaceController {

    private PlaceServiceImplementation placeServieImplementation;

    public PlaceController(PlaceServiceImplementation placeServieImplementation) {
        this.placeServieImplementation = placeServieImplementation;
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody PlaceRequestDTO placeRequest) {
        var newPlace = placeServieImplementation.create(placeRequest);
        return ResponseEntity.ok().body(newPlace);
    }

}