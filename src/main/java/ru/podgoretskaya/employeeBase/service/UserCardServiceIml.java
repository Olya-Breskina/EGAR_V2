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
// получение катрочки по id
public class UserCardServiceIml implements UserCardService {
    private final PersonRepo personRepo;
    private final EmployeeCardMap employeeCardMap;
    @Override
    public EmployeeCardDTO getCard(Long id) {
        PersonEntity entity = personRepo.findById(id).orElseThrow(NoSuchElementException::new);
        return employeeCardMap.toDto(entity);
    }
}
