package ru.podgoretskaya.employeeBase.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.podgoretskaya.employeeBase.dto.EmployeeCardDTO;
import ru.podgoretskaya.employeeBase.dto.PersonDTO;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;
import ru.podgoretskaya.employeeBase.mapper.EmployeeCardMap;
import ru.podgoretskaya.employeeBase.mapper.PersonMap;
import ru.podgoretskaya.employeeBase.repository.PersonRepo;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class GetCardImlTest {
    ObjectMapper objectMapper = new ObjectMapper();
    PersonRepo personRepo = Mockito.mock(PersonRepo.class);
    EmployeeCardMap employeeCardMap = new EmployeeCardMap();
    GetCard getCard = new GetCardIml(personRepo, employeeCardMap);
    PersonMap personMap = new PersonMap();

    @BeforeEach
    void beforeEach() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void getCard() throws IOException {
        Long id = 1L;
        PersonDTO personDTO = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/PersonDTO.json"), PersonDTO.class);
        PersonEntity personEntity = personMap.toEntity(personDTO);
        Mockito.when(personRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(personEntity));


        EmployeeCardDTO employeeCardDTO =  getCard.getCard(id);
        assertNotNull(employeeCardDTO);
        assertEquals("Иван", employeeCardDTO.getFirstName());

    }
}
