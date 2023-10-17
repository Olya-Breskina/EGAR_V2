package ru.podgoretskaya.employeeBase.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import ru.podgoretskaya.employeeBase.dto.DayOff;
import ru.podgoretskaya.employeeBase.dto.PersonDTO;
import ru.podgoretskaya.employeeBase.dto.SickDays;
import ru.podgoretskaya.employeeBase.dto.Vacation;
import ru.podgoretskaya.employeeBase.entity.DaysOffWorkEntity;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;
import ru.podgoretskaya.employeeBase.mapper.AccountingMap;
import ru.podgoretskaya.employeeBase.mapper.DaysOffWorkMap;
import ru.podgoretskaya.employeeBase.mapper.PersonMap;
import ru.podgoretskaya.employeeBase.repository.AccountingRepo;
import ru.podgoretskaya.employeeBase.repository.DaysOffWorkRepo;
import ru.podgoretskaya.employeeBase.repository.PersonRepo;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
// сохранение в бд
public class PersonService implements SaveInDB {
    private final PersonMap personMap;
    private final PersonRepo personRepo;
    private final AccountingMap accountingMap;
    private final AccountingRepo accountingRepo;
    private final DaysOffWorkMap daysOffWorkMap;
    private final DaysOffWorkRepo daysOffWorkRepo;

    @Override
    public Long savePerson(PersonDTO dto) {
        PersonEntity personEntity;
        try {
            personEntity = personRepo.save(personMap.toEntity(dto));
            return personEntity.getPersonID();
        } catch (HttpMessageNotReadableException e) {
            return Long.valueOf(0);
        }
    }

    @Override
    public void saveDayOff(DayOff dto, Long id) {
        DaysOffWorkEntity daysOffWorkEntity;
        PersonEntity personEntity =  personRepo.findById(id).orElseThrow(NoSuchElementException::new);
        daysOffWorkEntity = daysOffWorkRepo.save(daysOffWorkMap.dayOffToEntity(dto));
        daysOffWorkEntity.setPerson(personEntity);
        personRepo.save(personEntity);
    }

    @Override
    public void saveVacation(Vacation dto, Long id) {
        DaysOffWorkEntity daysOffWorkEntity;
        PersonEntity personEntity;
        personEntity = personRepo.findById(id).orElseThrow(NoSuchElementException:: new);
        daysOffWorkEntity= daysOffWorkRepo.save(daysOffWorkMap.vacationToEntity(dto));
        daysOffWorkEntity.setPerson(personEntity);
        personRepo.save(personEntity);

    }

    @Override
    public void saveSickDays(SickDays dto, Long id) {
        DaysOffWorkEntity daysOffWorkEntity;
        PersonEntity personEntity;
        personEntity = personRepo.findById(id).orElseThrow(NoSuchElementException:: new);
        daysOffWorkEntity= daysOffWorkRepo.save(daysOffWorkMap.sickDaysToEntity(dto));
        daysOffWorkEntity.setPerson(personEntity);
        personRepo.save(personEntity);
    }
}

