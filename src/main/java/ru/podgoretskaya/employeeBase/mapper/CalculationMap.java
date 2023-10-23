package ru.podgoretskaya.employeeBase.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.podgoretskaya.employeeBase.dto.CalculationDTO;
import ru.podgoretskaya.employeeBase.dto.DayOff;
import ru.podgoretskaya.employeeBase.dto.SickDays;
import ru.podgoretskaya.employeeBase.dto.Vacation;
import ru.podgoretskaya.employeeBase.entity.DaysOffWorkEntity;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;

import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CalculationMap {
    private final DaysOffWorkMap daysOffWorkMap;

    public CalculationDTO toDto(PersonEntity personEntity, List<DaysOffWorkEntity> byPersonId) {

        List<Vacation> lv = new LinkedList<>();
        List<SickDays> ls = new LinkedList<>();
        List<DayOff> ld = new LinkedList<>();
        for (DaysOffWorkEntity dayOff : byPersonId) {
            String absenceReason = dayOff.getAbsenceReason();
            if ("DayOff".equalsIgnoreCase(absenceReason)) {
                ld.add(daysOffWorkMap.dayOffToDTO(dayOff));
            } else if ("Vacation".equalsIgnoreCase(absenceReason)) {
                lv.add(daysOffWorkMap.vacationToDTO(dayOff));
            } else if ("SickDays".equalsIgnoreCase(absenceReason)) {
                ls.add(daysOffWorkMap.sickDaysToDTO(dayOff));
            }
        }
        CalculationDTO calculationDTO = new CalculationDTO();
        calculationDTO.setVacations(lv);
        calculationDTO.setSickDays(ls);
        calculationDTO.setDayOff(ld);
        calculationDTO.setSalary(personEntity.getSalary());
        calculationDTO.setWorkExperienceCurrent(personEntity.getWorkExperienceCurrent());
        return calculationDTO;
    }
}
