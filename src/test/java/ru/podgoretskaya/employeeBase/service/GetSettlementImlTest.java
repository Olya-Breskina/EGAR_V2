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
import ru.podgoretskaya.employeeBase.entity.AccountingEntity;
import ru.podgoretskaya.employeeBase.entity.DaysOffWorkEntity;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;
import ru.podgoretskaya.employeeBase.mapper.AccountingMap;
import ru.podgoretskaya.employeeBase.mapper.CalculationMap;
import ru.podgoretskaya.employeeBase.mapper.DaysOffWorkMap;
import ru.podgoretskaya.employeeBase.mapper.PersonMap;
import ru.podgoretskaya.employeeBase.repository.AccountingRepo;
import ru.podgoretskaya.employeeBase.repository.DaysOffWorkRepo;
import ru.podgoretskaya.employeeBase.repository.PersonRepo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class GetSettlementImlTest {
    ObjectMapper objectMapper = new ObjectMapper();
    DaysOffWorkMap daysOffWorkMap = new DaysOffWorkMap();
    AccountingClient accountingClient = Mockito.mock(AccountingClient.class);
    PersonRepo personRepo = Mockito.mock(PersonRepo.class);
    DaysOffWorkRepo daysOffWorkRepo = Mockito.mock(DaysOffWorkRepo.class);
    AccountingMap accountingMap = new AccountingMap();
    AccountingRepo accountingRepo = Mockito.mock(AccountingRepo.class);
    CalculationMap calculationMap = new CalculationMap(daysOffWorkMap);
    GetSettlementIml getSettlementIml = new GetSettlementIml(accountingClient, personRepo, daysOffWorkRepo, accountingMap, accountingRepo, calculationMap);
    PersonMap personMap = new PersonMap();

    @BeforeEach
    void beforeAll() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void getSettlement() throws IOException {
        Long id = 1L;
        PersonDTO personDTO = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/PersonDTO.json"), PersonDTO.class);
        PersonEntity personEntity = personMap.toEntity(personDTO);
        Mockito.when(personRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(personEntity));
        DayOff dto = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/DaysOffWorkDTO.json"), DayOff.class);
        Vacation vDto = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/VacationDTO.json"), Vacation.class);
        SickDays sDto = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/SickDaysDTO.json"),   SickDays.class);
        DaysOffWorkEntity daysOffWorkEntity = daysOffWorkMap.dayOffToEntity(dto);
        DaysOffWorkEntity daysOffWorkEntity2 = daysOffWorkMap.vacationToEntity(vDto);
        DaysOffWorkEntity daysOffWorkEntity3 = daysOffWorkMap.sickDaysToEntity(sDto);
        List<DaysOffWorkEntity> listD = new ArrayList<>();
        listD.add(daysOffWorkEntity);
        listD.add(daysOffWorkEntity2);
        listD.add(daysOffWorkEntity3);
        //  CalculationDTO calculationDTO = calculationMap.toDto(personEntity, listD);
        AccountingDTO accountingDTO = objectMapper.readValue(new File("src/test/resources/service/SaveInDB/AccountingDTO.json"), AccountingDTO.class);
        Mockito.when(accountingClient.getSettlement(Mockito.any())).thenReturn(ResponseEntity.ok(accountingDTO));
        AccountingEntity accountingEntity = accountingMap.toEntity(accountingDTO);
        Mockito.when(accountingRepo.save(Mockito.any())).thenReturn(accountingEntity);
        personEntity.setAccountingEntity(accountingEntity);
        Mockito.when(personRepo.save(Mockito.any())).thenReturn(personEntity);

        AccountingDTO accountingDTO2 = getSettlementIml.getSettlement(id);
        assertNotNull(accountingDTO2);
    }
}
/*
  @Override
    public AccountingDTO getSettlement(Long id) {
        PersonEntity personEntity = personRepo.findById(id).orElseThrow(NoSuchElementException::new);
        List<DaysOffWorkEntity> byPersonId = daysOffWorkRepo.findByPerson(personEntity);
        CalculationDTO calculationDTO = calculationMap.toDto(personEntity, byPersonId);
        AccountingDTO accountingDTO = jsonCollecting(calculationDTO);
        AccountingEntity accountingEntity = accountingMap.toEntity(accountingDTO);
        accountingRepo.save(accountingEntity);
        personEntity.setAccountingEntity(accountingEntity);
        personRepo.save(personEntity);
        return accountingDTO;
    }

    private AccountingDTO jsonCollecting(CalculationDTO calculationDTO) {
        return accountingClient.getSettlement(calculationDTO).getBody();
    }
 */