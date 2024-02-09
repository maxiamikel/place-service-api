package com.maxi.places.placeserviceapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.places.placeserviceapi.domains.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
