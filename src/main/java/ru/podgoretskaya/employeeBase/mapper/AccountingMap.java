package ru.podgoretskaya.employeeBase.mapper;

import org.springframework.stereotype.Component;
import ru.podgoretskaya.employeeBase.dto.AccountingDTO;
import ru.podgoretskaya.employeeBase.entity.AccountingEntity;

@Component
public class AccountingMap implements Mapper<AccountingEntity, AccountingDTO> {
    @Override
    public AccountingEntity toEntity(AccountingDTO dto) {
        AccountingEntity entity = new AccountingEntity();
        entity.setWorkDays(dto.getWorkDays());
        entity.setSalaryOfWorkDays(dto.getSalaryOfWorkDays());
        entity.setDaysOfDayOff(dto.getDaysOfDayOff());
        entity.setSalaryOfDayOff(dto.getSalaryOfDayOff());
        entity.setDaysOfVacation(dto.getDaysOfVacation());
        entity.setSalaryOfVacation(dto.getSalaryOfVacation());
        entity.setDaysOfSickDay(dto.getDaysOfSickDay());
        entity.setSalaryOfSickDay(dto.getSalaryOfSickDay());
        entity.setSalaryGROSS(dto.getSalaryGROSS());
        entity.setTax(dto.getTax());
        entity.setSalaryOnHandy(dto.getSalaryOnHandy());
        return entity;
    }

    @Override
    public AccountingDTO toDto(AccountingEntity entity) {
        AccountingDTO dto = new AccountingDTO();
        dto.setWorkDays(entity.getWorkDays());
        dto.setDaysOfDayOff(entity.getDaysOfDayOff());
        dto.setSalaryOfDayOff(entity.getSalaryOfDayOff());
        dto.setDaysOfVacation(entity.getDaysOfVacation());
        dto.setSalaryOfVacation(entity.getSalaryOfVacation());
        dto.setDaysOfSickDay(entity.getDaysOfSickDay());
        dto.setSalaryOfSickDay(entity.getSalaryOfSickDay());
        dto.setSalaryGROSS(entity.getSalaryGROSS());
        dto.setTax(entity.getTax());
        dto.setSalaryOnHandy(entity.getSalaryOnHandy());
        return dto;
    }
}
