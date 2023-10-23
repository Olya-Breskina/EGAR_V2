package ru.podgoretskaya.employeeBase.service;

import ru.podgoretskaya.employeeBase.dto.AccountingDTO;

public interface GetSettlement {
    AccountingDTO getSettlement(Long id);
}
