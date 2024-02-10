package com.maxi.places.placeserviceapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.maxi.places.placeserviceapi.dtos.PlaceRequestDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PlaceServiceApiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	public void testCreatePlaceSuccess() {
		var name = "Place teste";
		var state = "State teste";
		var slug = "Slug teste";
		var city = "City test";

		webTestClient
				.post()
				.uri("/api/v1/places")
				.bodyValue(
						new PlaceRequestDTO(name, slug, state, city))
				.exchange()
				.expectBody()
				.jsonPath("name").isEqualTo(name)
				.jsonPath("state").isEqualTo(state)
				.jsonPath("slug").isEqualTo(slug)
				.jsonPath("city").isEqualTo(city)
				.jsonPath("createAt").isNotEmpty()
				.jsonPath("updateAt").isNotEmpty();
	}

	@Test
	public void testCreatePlaceFailure() {
		var name = "";
		var slug = "";
		var state = "State";
		var city = "";

		webTestClient
				.post()
				.uri("/api/v1/places")
				.bodyValue(
						new PlaceRequestDTO(name, slug, state, city))
				.exchange()
				.expectStatus().isBadRequest();
	}
}