package ru.podgoretskaya.employeeBase.mapper;

import org.springframework.stereotype.Component;
import ru.podgoretskaya.employeeBase.dto.DayOff;
import ru.podgoretskaya.employeeBase.dto.SickDays;
import ru.podgoretskaya.employeeBase.dto.Vacation;
import ru.podgoretskaya.employeeBase.entity.DaysOffWorkEntity;

@Component
public class DaysOffWorkMap {
    public DaysOffWorkEntity dayOffToEntity(DayOff dto) {
        DaysOffWorkEntity entity = new DaysOffWorkEntity();
        entity.setStart(dto.getDate());
        entity.setFinish(dto.getDate());
        entity.setAbsenceReason("DayOff");
        return entity;
    }

    public DaysOffWorkEntity vacationToEntity(Vacation dto) {
        DaysOffWorkEntity entity = new DaysOffWorkEntity();
        entity.setStart(dto.getStart());
        entity.setFinish(dto.getEnd());
        entity.setAbsenceReason("Vacation");
        return entity;
    }

    public DaysOffWorkEntity sickDaysToEntity(SickDays dto) {
        DaysOffWorkEntity entity = new DaysOffWorkEntity();
        entity.setStart(dto.getStart());
        entity.setFinish(dto.getEnd());
        entity.setAbsenceReason("SickDays");
        return entity;
    }

    public DayOff dayOffToDTO(DaysOffWorkEntity entity) {
        DayOff dto = new DayOff();
        dto.setDate(entity.getStart());
        return dto;
    }

    public Vacation vacationToDTO(DaysOffWorkEntity entity) {
        Vacation dto = new Vacation();
        dto.setStart(entity.getStart());
        dto.setEnd(entity.getFinish());
        return dto;
    }

    public SickDays sickDaysToDTO(DaysOffWorkEntity entity) {
        SickDays dto = new SickDays();
        dto.setStart(entity.getStart());
        dto.setEnd(entity.getFinish());
        return dto;
    }
}