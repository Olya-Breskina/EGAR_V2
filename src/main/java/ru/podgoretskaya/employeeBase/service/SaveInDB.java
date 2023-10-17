package ru.podgoretskaya.employeeBase.service;

import ru.podgoretskaya.employeeBase.dto.DayOff;
import ru.podgoretskaya.employeeBase.dto.PersonDTO;
import ru.podgoretskaya.employeeBase.dto.SickDays;
import ru.podgoretskaya.employeeBase.dto.Vacation;

public interface SaveInDB {
    Long savePerson (PersonDTO dto);
    void saveDayOff (DayOff dto, Long id);
    void saveVacation (Vacation dto, Long id);
    void saveSickDays (SickDays dto, Long id);
}
