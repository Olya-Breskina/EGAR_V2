package ru.podgoretskaya.employeeBase.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.podgoretskaya.employeeBase.dto.GuideDTO;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;
import ru.podgoretskaya.employeeBase.mapper.GuideMap;
import ru.podgoretskaya.employeeBase.repository.PersonRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuideService implements GetAll {
    private final PersonRepo personRepo;
    private final GuideMap guideMap;

    @Override
    public List<GuideDTO> getAll() {
        List<PersonEntity> entity = personRepo.findAll();
        return entity.stream().map(guideMap::toDto).collect(Collectors.toList());
    }
}
