package ru.podgoretskaya.employeeBase.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.podgoretskaya.employeeBase.dto.PersonDTO;

import java.io.File;

public class APITest extends AbstractIntegrationTest {
    @Autowired
    APIController apiController;


    @Test
    void saveInDB() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        WebTestClient.bindToController(apiController)
                .build()
                .post()
                .uri("/base/save")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(objectMapper.readValue(new File("src/test/resources/service/SaveInDB/PersonDTO.json"), PersonDTO.class))
                .exchange()
                .expectStatus().isOk();


    }

    @SneakyThrows
    private PersonDTO personDTOCreate() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File("src/test/resources/service/SaveInDB/PersonDTO.json"), PersonDTO.class);
    }
}
