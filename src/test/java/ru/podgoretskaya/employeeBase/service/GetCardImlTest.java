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
import ru.podgoretskaya.employeeBase.repository.PersonRepo;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class GetCardImlTest {
    ObjectMapper objectMapper = new ObjectMapper();
    PersonRepo personRepo = Mockito.mock(PersonRepo.class);
    EmployeeCardMap employeeCardMap = new EmployeeCardMap();
    GetCardIml getCardIml = new GetCardIml(personRepo, employeeCardMap);

    @BeforeEach
    void beforeAll() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void getCard() throws IOException {
       // PersonDTO personDTO = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/PersonDTO.json"), PersonDTO.class);
        Long id = 1L;
        PersonEntity personEntity=new PersonEntity();
        Mockito.when(personRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(personEntity));


        EmployeeCardDTO employeeCardDTO =  getCardIml.getCard(id);
        assertNotNull(employeeCardDTO);
    }
}
