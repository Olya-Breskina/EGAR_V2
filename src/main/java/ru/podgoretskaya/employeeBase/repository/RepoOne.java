package ru.podgoretskaya.employeeBase.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.podgoretskaya.employeeBase.dto.PersonDTO;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;
import ru.podgoretskaya.employeeBase.mapper.PersonMap;

@Component
@RequiredArgsConstructor
@Slf4j
public class RepoOne {

    private final EntityManager entityManager;

    private final PersonMap personMap;

    public PersonDTO getCard(Long id) {
        PersonEntity pe = (PersonEntity) entityManager.createQuery("FROM PersonEntity p WHERE p.personID = :id")
                .setParameter("id", id)
                .getSingleResult();
        return personMap.toDto(pe);
//убрать map и возвращать entity, а в сервисе делать dto
    }
}
