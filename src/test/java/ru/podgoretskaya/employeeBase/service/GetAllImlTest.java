package ru.podgoretskaya.employeeBase.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.podgoretskaya.employeeBase.dto.GuideDTO;
import ru.podgoretskaya.employeeBase.dto.PersonDTO;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;
import ru.podgoretskaya.employeeBase.mapper.GuideMap;
import ru.podgoretskaya.employeeBase.mapper.PersonMap;
import ru.podgoretskaya.employeeBase.repository.PersonRepo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class GetAllImlTest {
    ObjectMapper objectMapper = new ObjectMapper();
    PersonRepo personRepo = Mockito.mock(PersonRepo.class);
    GuideMap guideMap = new GuideMap();
    GetAll getAll = new GetAllIml(personRepo, guideMap);
    PersonMap personMap = new PersonMap();

    @BeforeEach
    void beforeEach() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void getAll() throws Exception {
        PersonDTO personDTO = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/PersonDTO.json"), PersonDTO.class);
        PersonDTO personDTO2 = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/PersonDTO2.json"), PersonDTO.class);
        List<PersonEntity> listP = new ArrayList<>();
        PersonEntity personEntity = personMap.toEntity(personDTO);
        personEntity.setPersonID(1L);
        PersonEntity personEntity2 = personMap.toEntity(personDTO2);
        personEntity2.setPersonID(2L);
        listP.add(personEntity);
        listP.add(personEntity2);
        Mockito.when(personRepo.findAll()).thenReturn(listP);


        List<GuideDTO> guideDTO = getAll.getAll();
        assertNotNull(guideDTO);
        assertEquals(2, guideDTO.size());
    }
}