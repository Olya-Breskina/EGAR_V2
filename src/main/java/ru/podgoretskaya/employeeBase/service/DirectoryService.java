package ru.podgoretskaya.employeeBase.service;

import ru.podgoretskaya.employeeBase.dto.GuideDTO;

import java.util.List;

public interface DirectoryService {
    List<GuideDTO> getAll();
}
