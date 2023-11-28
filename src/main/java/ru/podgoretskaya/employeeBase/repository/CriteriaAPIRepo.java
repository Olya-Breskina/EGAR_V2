package ru.podgoretskaya.employeeBase.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.podgoretskaya.employeeBase.dto.GuideDTO;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CriteriaAPIRepo{
    private final EntityManager entityManager;
    public  List<PersonEntity> getAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> query =criteriaBuilder.createQuery(PersonEntity.class);
        Root<PersonEntity> from = query.from(PersonEntity.class);
        TypedQuery<PersonEntity> personEntityTypedQuery = entityManager.createQuery(query);
        return personEntityTypedQuery.getResultList();
    }
}
