package ru.podgoretskaya.employeeBase.mapper;

import org.springframework.stereotype.Component;
import ru.podgoretskaya.employeeBase.dto.PersonDTO;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;

@Component
public class PersonMap implements Mapper<PersonEntity, PersonDTO> {
    @Override
    public PersonEntity toEntity(PersonDTO dto) {
        PersonEntity entity = new PersonEntity();
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setBirthdate(dto.getBirthdate());
        entity.setPosition(dto.getPosition());
        entity.setDepartment(dto.getDepartment());
        entity.setGrade(dto.getGrade());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setOccupancy(dto.getOccupancy());
        entity.setWorkingMode(dto.getWorkingMode());
        entity.setWorkExperienceCurrent(dto.getWorkExperienceCurrent());
        entity.setSalary(dto.getSalary());
        return entity;
    }

    @Override
    public PersonDTO toDto(PersonEntity entity) {
        PersonDTO dto = new PersonDTO();
        dto.setLastName(entity.getLastName());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setBirthdate(entity.getBirthdate());
        dto.setPosition(entity.getPosition());
        dto.setDepartment(entity.getDepartment());
        dto.setGrade(entity.getGrade());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        dto.setOccupancy(entity.getOccupancy());
        dto.setWorkingMode(entity.getWorkingMode());
        dto.setWorkExperienceCurrent(entity.getWorkExperienceCurrent());
        dto.setSalary(entity.getSalary());
        return dto;
    }

}
