package ru.podgoretskaya.employeeBase.repository;

import org.springframework.data.repository.CrudRepository;
import ru.podgoretskaya.employeeBase.entity.AccountingEntity;

public interface AccountingRepo extends CrudRepository<AccountingEntity, Long> {
}
