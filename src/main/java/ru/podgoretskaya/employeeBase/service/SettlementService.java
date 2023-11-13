package ru.podgoretskaya.employeeBase.service;

import ru.podgoretskaya.employeeBase.dto.AccountingDTO;

public interface SettlementService {
    AccountingDTO getSettlement(Long id);
}
