package ru.podgoretskaya.employeeBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;

public interface PersonRepo extends JpaRepository<PersonEntity, Long> {
}
