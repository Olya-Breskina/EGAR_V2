package ru.podgoretskaya.employeeBase.mapper;

import org.springframework.stereotype.Component;
import ru.podgoretskaya.employeeBase.dto.DayOff;
import ru.podgoretskaya.employeeBase.dto.SickDays;
import ru.podgoretskaya.employeeBase.dto.Vacation;
import ru.podgoretskaya.employeeBase.entity.DaysOffWorkEntity;

@Component
public class DaysOffWorkMap {
    public DaysOffWorkEntity toEntity(DayOff dto, Vacation dto1, SickDays dto2) {
        DaysOffWorkEntity entity = new DaysOffWorkEntity();
        entity.setDayOff(dto.getDate());
        entity.setSick_days_start(dto2.getStart());
        entity.setSick_days_end(dto2.getEnd());
        entity.setVacation_start(dto1.getStart());
        entity.setVacation_end(dto1.getEnd());
        return entity;
    }

}