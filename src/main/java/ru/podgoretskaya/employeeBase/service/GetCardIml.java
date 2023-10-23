package ru.podgoretskaya.employeeBase.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.podgoretskaya.employeeBase.dto.EmployeeCardDTO;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;
import ru.podgoretskaya.employeeBase.mapper.EmployeeCardMap;
import ru.podgoretskaya.employeeBase.repository.PersonRepo;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetCardIml implements GetCard {
    private final PersonRepo personRepo;
    private final EmployeeCardMap employeeCardMap;

    @Override
    public EmployeeCardDTO getCard(Long applicationId) {
        PersonEntity entity = personRepo.findById(applicationId).orElseThrow(NoSuchElementException::new);
        return employeeCardMap.toDto(entity);
    }
}
