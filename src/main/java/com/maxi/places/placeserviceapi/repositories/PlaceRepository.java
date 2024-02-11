package com.maxi.places.placeserviceapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.maxi.places.placeserviceapi.domains.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    public Place findByName(String name);

    @Query("SELECT p FROM Place p WHERE p.placeStatus = ACTIVE")
    public List<Place> findAll();

    @Query("SELECT ps FROM Place ps WHERE ps.state =:state")
    public List<Place> findByState(@RequestParam(name = "state") String state);
}
