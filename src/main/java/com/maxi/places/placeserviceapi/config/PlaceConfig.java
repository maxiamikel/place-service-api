package com.maxi.places.placeserviceapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.maxi.places.placeserviceapi.repositories.PlaceRepository;
import com.maxi.places.placeserviceapi.services.PlaceServiceImplementation;

@Configuration
@EnableJpaAuditing
public class PlaceConfig {

    @Bean
    public PlaceServiceImplementation placeServieImplementation(PlaceRepository placeRepository) {
        return new PlaceServiceImplementation(placeRepository);
    }

}
