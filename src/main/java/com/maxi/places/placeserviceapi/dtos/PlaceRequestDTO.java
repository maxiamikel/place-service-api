package com.maxi.places.placeserviceapi.dtos;

import com.maxi.places.placeserviceapi.domains.Place;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceRequestDTO {
    private String name;
    private String slug;
    private String status;

    public PlaceRequestDTO() {
    }

    public PlaceRequestDTO(Place place) {
        this.name = place.getName();
        this.slug = place.getSlug();
        this.status = place.getStatus();
    }

    public PlaceRequestDTO(String name, String slug, String status) {
        this.name = name;
        this.slug = slug;
        this.status = status;
    }

}
