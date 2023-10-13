package ru.podgoretskaya.employeeBase.mapper;

import org.springframework.stereotype.Component;
import ru.podgoretskaya.employeeBase.dto.EmployeeCardDTO;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;

@Component
public class EmployeeCardMap {
    public EmployeeCardDTO toDto(PersonEntity entity) {
        EmployeeCardDTO dto = new EmployeeCardDTO();
        dto.setLastName(entity.getLastName());
        dto.setFirstName(entity.getFirstName());
        dto.setBirthdate(entity.getBirthdate());
        dto.setPosition(entity.getPosition());
        dto.setDepartment(entity.getDepartment());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        dto.setOccupancy(entity.getOccupancy());
        dto.setWorkingMode(entity.getWorkingMode());
        return dto;
    }
}
