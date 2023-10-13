package ru.podgoretskaya.employeeBase.service;

import ru.podgoretskaya.employeeBase.dto.PersonDTO;

public interface SaveInDB {
    Long savePerson (PersonDTO dto);
}
