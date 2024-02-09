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
		var status = "Status teste";
		var slug = "Slug teste";

		webTestClient
				.post()
				.uri("/api/v1/places")
				.bodyValue(
						new PlaceRequestDTO(name, slug, status))
				.exchange()
				.expectBody()
				.jsonPath("name").isEqualTo(name)
				.jsonPath("status").isEqualTo(status)
				.jsonPath("slug").isEqualTo(slug)
				.jsonPath("createAt").isNotEmpty()
				.jsonPath("updateAt").isNotEmpty();
	}

	@Test
	public void testCreatePlaceFailure() {
		var name = "";
		var slug = "";
		var status = "Status";

		webTestClient
				.post()
				.uri("/api/v1/places")
				.bodyValue(
						new PlaceRequestDTO(name, slug, status))
				.exchange()
				.expectStatus().isBadRequest();
	}
}