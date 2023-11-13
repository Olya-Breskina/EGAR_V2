package ru.podgoretskaya.employeeBase.service;

import ru.podgoretskaya.employeeBase.dto.EmployeeCardDTO;

public interface UserCardService {
    EmployeeCardDTO getCard(Long applicationId);
}
