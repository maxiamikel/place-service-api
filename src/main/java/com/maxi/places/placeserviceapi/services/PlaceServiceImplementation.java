package com.maxi.places.placeserviceapi.services;

import java.time.LocalDate;

import com.maxi.places.placeserviceapi.domains.Place;
import com.maxi.places.placeserviceapi.dtos.PlaceRequestDTO;
import com.maxi.places.placeserviceapi.dtos.PlaceResponseDTO;
import com.maxi.places.placeserviceapi.repositories.PlaceRepository;

public class PlaceServiceImplementation implements PlaceServie {

    private PlaceRepository placeRepository;

    public PlaceServiceImplementation(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public PlaceResponseDTO create(PlaceRequestDTO placeDTO) {
        Place place = new Place();

        place.setId(null);
        place.setCreateAt(LocalDate.now());
        place.setName(placeDTO.getName());
        place.setSlug(placeDTO.getSlug());
        place.setStatus(placeDTO.getStatus());
        place.setUpdateAt(LocalDate.now());
        placeRepository.save(place);

        PlaceResponseDTO created = new PlaceResponseDTO(place);
        return created;

    }

}
