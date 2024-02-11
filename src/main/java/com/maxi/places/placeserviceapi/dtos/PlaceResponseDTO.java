package com.maxi.places.placeserviceapi.dtos;

import java.time.LocalDate;

import com.maxi.places.placeserviceapi.domains.Place;
import com.maxi.places.placeserviceapi.enums.PlaceStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceResponseDTO {

    private String name;
    private String slug;
    private String city;
    private String state;
    private PlaceStatus placeStatus;
    private LocalDate createAt;
    private LocalDate updateAt;

    public PlaceResponseDTO(Place place) {
        this.name = place.getName();
        this.slug = place.getSlug();
        this.state = place.getState();
        this.city = place.getCity();
        this.placeStatus = place.getPlaceStatus();
        this.createAt = place.getCreateAt();
        this.updateAt = place.getUpdateAt();
    }

    public PlaceResponseDTO() {
    }

}
