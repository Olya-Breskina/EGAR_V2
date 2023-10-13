package ru.podgoretskaya.employeeBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.podgoretskaya.employeeBase.entity.DaysOffWorkEntity;

public interface DaysOffWorkRepo extends JpaRepository<DaysOffWorkEntity,Long> {
}
