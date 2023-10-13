package ru.podgoretskaya.employeeBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.podgoretskaya.employeeBase.entity.AccountingEntity;

public interface AccountingRepo  extends JpaRepository<AccountingEntity,Long> {
}
