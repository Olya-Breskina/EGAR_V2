package ru.podgoretskaya.employeeBase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.podgoretskaya.employeeBase.entity.DaysOffWorkEntity;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;

import java.util.List;

public interface DaysOffWorkRepo extends CrudRepository<DaysOffWorkEntity, Long> {
    List<DaysOffWorkEntity> findByPerson(PersonEntity personEntity);
}
