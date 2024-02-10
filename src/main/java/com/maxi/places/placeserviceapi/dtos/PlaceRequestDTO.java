package com.maxi.places.placeserviceapi.dtos;

import com.maxi.places.placeserviceapi.domains.Place;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceRequestDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String slug;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    public PlaceRequestDTO() {
    }

    public PlaceRequestDTO(Place place) {
        this.name = place.getName();
        this.slug = place.getSlug();
        this.state = place.getSlug();
        this.city = place.getCity();
    }

    public PlaceRequestDTO(String name, String slug, String state, String city) {
        this.name = name;
        this.slug = slug;
        this.state = state;
        this.city = city;
    }

}
