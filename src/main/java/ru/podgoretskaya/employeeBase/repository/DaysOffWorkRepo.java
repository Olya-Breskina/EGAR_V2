package ru.podgoretskaya.employeeBase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.podgoretskaya.employeeBase.entity.DaysOffWorkEntity;

public interface DaysOffWorkRepo extends CrudRepository<DaysOffWorkEntity, Long> {
}
