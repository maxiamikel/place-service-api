package com.maxi.places.placeserviceapi.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.maxi.places.placeserviceapi.dtos.PlaceRequestDTO;
import com.maxi.places.placeserviceapi.dtos.PlaceResponseDTO;

public interface PlaceServie {

    public PlaceResponseDTO create(PlaceRequestDTO placeDTO);

    public List<PlaceResponseDTO> findAll(Pageable page);

    public PlaceResponseDTO findById(Long id);

    public PlaceResponseDTO update(PlaceRequestDTO placeRequest);

    public void delete(Long id);

    public PlaceResponseDTO findByName(String name);

    public List<PlaceResponseDTO> findByState(String state);

}
