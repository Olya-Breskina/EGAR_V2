package ru.podgoretskaya.employeeBase.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import ru.podgoretskaya.employeeBase.client.AccountingClient;
import ru.podgoretskaya.employeeBase.dto.*;
import ru.podgoretskaya.employeeBase.entity.DaysOffWorkEntity;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;
import ru.podgoretskaya.employeeBase.mapper.DaysOffWorkMap;
import ru.podgoretskaya.employeeBase.mapper.PersonMap;
import ru.podgoretskaya.employeeBase.repository.DaysOffWorkRepo;
import ru.podgoretskaya.employeeBase.repository.PersonRepo;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class SaveInDBImlTest {
    ObjectMapper objectMapper = new ObjectMapper();
    PersonRepo personRepo = Mockito.mock(PersonRepo.class);
    DaysOffWorkRepo daysOffWorkRepo = Mockito.mock(DaysOffWorkRepo.class);
    PersonMap personMap = new PersonMap();
    DaysOffWorkMap daysOffWorkMap = new DaysOffWorkMap();
    AccountingClient accountingClient = Mockito.mock(AccountingClient.class);
    SaveInDB saveInDB = new SaveInDBIml(personMap, personRepo, daysOffWorkMap, daysOffWorkRepo, accountingClient);

    @BeforeEach
    void beforeEach() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void savePerson() throws IOException {
        PersonDTO personDTO = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/PersonDTO.json"), PersonDTO.class);
        Mockito.when(accountingClient.getCard(Mockito.any())).thenReturn(ResponseEntity.ok(personDTO));
        PersonEntity personEntity = personMap.toEntity(personDTO);
        Mockito.when(personRepo.save(Mockito.any())).thenReturn(personEntity);

        saveInDB.savePerson(personDTO);

        Mockito.verify(personRepo).save(personEntity);
        Mockito.verify(accountingClient).getCard(personDTO);
    }

    @Test
    void saveDayOff() throws IOException
    {
        DayOff dto = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/DaysOffWorkDTO.json"), DayOff.class);
        Long id = 1L;
        PersonEntity personEntity=new PersonEntity();
        DaysOffWorkEntity daysOffWorkEntity = daysOffWorkMap.dayOffToEntity(dto);
        Mockito.when(personRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(personEntity));
        daysOffWorkEntity.setPerson(personEntity);
        Mockito.when(personRepo.save(Mockito.any())).thenReturn(personEntity);
        Mockito.when(daysOffWorkRepo.save(Mockito.any())).thenReturn(daysOffWorkEntity);

        saveInDB.saveDayOff(dto,id);

        Mockito.verify(personRepo).save(personEntity);
    }

    @Test
    void saveVacation() throws IOException {
        Vacation dto = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/VacationDTO.json"),  Vacation.class);
        Long id = 1L;
        PersonEntity personEntity=new PersonEntity();
        DaysOffWorkEntity daysOffWorkEntity = daysOffWorkMap.vacationToEntity(dto);
        Mockito.when(personRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(personEntity));
        daysOffWorkEntity.setPerson(personEntity);
        Mockito.when(personRepo.save(Mockito.any())).thenReturn(personEntity);
        Mockito.when(daysOffWorkRepo.save(Mockito.any())).thenReturn(daysOffWorkEntity);

        saveInDB.saveVacation(dto,id);

        Mockito.verify(personRepo).save(personEntity);
    }

    @Test
    void saveSickDays() throws IOException {
        SickDays dto =  objectMapper.readValue(new File("src/test/resources/service/SaveInDB/SickDaysDTO.json"),  SickDays.class);
        Long id = 1L;
        PersonEntity personEntity=new PersonEntity();
        DaysOffWorkEntity daysOffWorkEntity = daysOffWorkMap.sickDaysToEntity(dto);
        Mockito.when(personRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(personEntity));
        daysOffWorkEntity.setPerson(personEntity);
        Mockito.when(personRepo.save(Mockito.any())).thenReturn(personEntity);
        Mockito.when(daysOffWorkRepo.save(Mockito.any())).thenReturn(daysOffWorkEntity);

        saveInDB.saveSickDays(dto,id);

        Mockito.verify(personRepo).save(personEntity);
    }
}
