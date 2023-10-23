package ru.podgoretskaya.employeeBase.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.podgoretskaya.employeeBase.client.AccountingClient;
import ru.podgoretskaya.employeeBase.dto.AccountingDTO;
import ru.podgoretskaya.employeeBase.dto.CalculationDTO;
import ru.podgoretskaya.employeeBase.entity.AccountingEntity;
import ru.podgoretskaya.employeeBase.entity.DaysOffWorkEntity;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;
import ru.podgoretskaya.employeeBase.mapper.AccountingMap;
import ru.podgoretskaya.employeeBase.mapper.CalculationMap;
import ru.podgoretskaya.employeeBase.repository.AccountingRepo;
import ru.podgoretskaya.employeeBase.repository.DaysOffWorkRepo;
import ru.podgoretskaya.employeeBase.repository.PersonRepo;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetSettlementIml implements GetSettlement {
    private final AccountingClient accountingClient;
    private final PersonRepo personRepo;
    private final DaysOffWorkRepo daysOffWorkRepo;
    private final AccountingMap accountingMap;
    private final AccountingRepo accountingRepo;
    private final CalculationMap calculationMap;

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
}
