package ru.podgoretskaya.employeeBase.service;

import ru.podgoretskaya.employeeBase.dto.EmployeeCardDTO;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;

public interface GetCard {
    EmployeeCardDTO getCard(Long applicationId);
}
