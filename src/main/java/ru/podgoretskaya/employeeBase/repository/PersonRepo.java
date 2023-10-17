package ru.podgoretskaya.employeeBase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;

public interface PersonRepo extends CrudRepository<PersonEntity, Long> {
}
