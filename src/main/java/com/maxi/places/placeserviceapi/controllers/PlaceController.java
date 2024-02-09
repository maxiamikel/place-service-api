package com.maxi.places.placeserviceapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/places")
public class PlaceController {

    @PostMapping("")
    public ResponseEntity<?> create() {
        return ResponseEntity.ok().body("Teste...");
    }

}
