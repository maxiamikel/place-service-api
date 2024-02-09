package com.maxi.places.placeserviceapi.services;

import com.maxi.places.placeserviceapi.dtos.PlaceRequestDTO;
import com.maxi.places.placeserviceapi.dtos.PlaceResponseDTO;

public interface PlaceServie {

    public PlaceResponseDTO create(PlaceRequestDTO placeDTO);
}
