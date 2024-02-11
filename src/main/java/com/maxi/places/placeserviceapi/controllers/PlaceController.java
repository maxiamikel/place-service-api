package com.maxi.places.placeserviceapi.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/new")
    public ResponseEntity<?> create(@Valid @RequestBody PlaceRequestDTO placeRequest) {
        var newPlace = placeServieImplementation.create(placeRequest);
        return ResponseEntity.ok().body(newPlace);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok().body(placeServieImplementation.findAll(page));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PlaceRequestDTO placeRequest) {
        return ResponseEntity.ok().body(placeServieImplementation.update(placeRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(placeServieImplementation.findById(id));
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(placeServieImplementation.findByName(name));
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<?> findByState(@PathVariable String state,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "1") Integer pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok().body(placeServieImplementation.findByState(state, page));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        placeServieImplementation.delete(id);
        return ResponseEntity.ok().body("Place ID [" + id + "] was successfully deleted");
    }
}