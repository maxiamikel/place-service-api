package com.maxi.places.placeserviceapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.places.placeserviceapi.domains.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    public Place findByName(String name);

    public List<Place> findByState(String state);
}
