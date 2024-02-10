package com.maxi.places.placeserviceapi.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;

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
        Place place = placeRepository.findByName(placeDTO.getName());
        if (place == null) {
            Place newPlace = new Place();
            newPlace.setId(null);
            newPlace.setCreateAt(LocalDate.now());
            newPlace.setName(placeDTO.getName());
            newPlace.setSlug(placeDTO.getSlug());
            newPlace.setState(placeDTO.getState());
            newPlace.setCity(placeDTO.getCity());
            newPlace.setUpdateAt(LocalDate.now());
            placeRepository.save(newPlace);

            PlaceResponseDTO created = new PlaceResponseDTO(newPlace);
            return created;
        }
        PlaceResponseDTO placeDB = new PlaceResponseDTO(place);
        return placeDB;
    }

    @Override
    public List<PlaceResponseDTO> findAll(Pageable page) {
        List<Place> placeList = placeRepository.findAll();
        List<PlaceResponseDTO> placeResponseDTOs = new ArrayList<PlaceResponseDTO>();
        placeResponseDTOs = placeList.stream().map(p -> new PlaceResponseDTO(p)).collect(Collectors.toList());
        return placeResponseDTOs;

    }

    @Override
    public PlaceResponseDTO update(PlaceRequestDTO placeRequest) {
        Optional<Place> place = placeRepository.findById(placeRequest.getId());

        if (!place.isPresent()) {
            throw new RuntimeException("Place id is not found");
        } else {

            Place placeDB = place.get();
            placeDB.setCity(placeRequest.getCity());
            placeDB.setName(placeRequest.getName());
            placeDB.setSlug(placeRequest.getSlug());
            placeDB.setState(placeRequest.getState());
            placeDB.setUpdateAt(LocalDate.now());

            placeRepository.saveAndFlush(placeDB);
            PlaceResponseDTO placeResponseDTO = new PlaceResponseDTO(placeDB);
            return placeResponseDTO;
        }
    }

    @Override
    public void delete(Long id) {
        if (this.findPlaceById(id) != null) {
            placeRepository.deleteById(id);
        }
    }

    @Override
    public PlaceResponseDTO findById(Long id) {
        Optional<Place> place = placeRepository.findById(id);
        if (!place.isPresent()) {
            throw new RuntimeException("Place Id is not found");
        }
        PlaceResponseDTO placeResp = new PlaceResponseDTO(place.get());
        return placeResp;

    }

    private Place findPlaceById(Long id) {
        return placeRepository.findById(id).orElseThrow(null);
    }

    @Override
    public PlaceResponseDTO findByName(String name) {
        Place place = placeRepository.findByName(name);
        PlaceResponseDTO placeResponseDTO = new PlaceResponseDTO(place);
        return placeResponseDTO;
    }

    @Override
    public List<PlaceResponseDTO> findByState(String state) {
        List<Place> placeList = placeRepository.findByState(state);
        List<PlaceResponseDTO> placeListDTO = new ArrayList<PlaceResponseDTO>();
        placeListDTO = placeList.stream().map(p -> new PlaceResponseDTO(p)).collect(Collectors.toList());
        return placeListDTO;
    }

}
