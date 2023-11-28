package ru.podgoretskaya.employeeBase.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.podgoretskaya.employeeBase.dto.EmployeeCardDTO;
import ru.podgoretskaya.employeeBase.mapper.EmployeeCardMap;
import ru.podgoretskaya.employeeBase.repository.PersonRepo;

//@Service
@RequiredArgsConstructor
@Slf4j
// получение катрочки по id
public class UserCardServiceIml implements UserCardService {//UserCardService
    private final PersonRepo personRepo;
    private final EmployeeCardMap employeeCardMap;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EmployeeCardDTO getCard(Long id) {
        return (EmployeeCardDTO) entityManager.createQuery("FROM Person p WHERE p.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }
}
