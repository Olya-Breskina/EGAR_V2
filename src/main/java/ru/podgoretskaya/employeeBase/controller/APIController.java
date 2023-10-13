package ru.podgoretskaya.employeeBase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.podgoretskaya.employeeBase.dto.EmployeeCardDTO;
import ru.podgoretskaya.employeeBase.dto.GuideDTO;
import ru.podgoretskaya.employeeBase.dto.PersonDTO;
import ru.podgoretskaya.employeeBase.service.GetAll;
import ru.podgoretskaya.employeeBase.service.GetCard;
import ru.podgoretskaya.employeeBase.service.SaveInDB;

import java.util.List;

@RestController
@RequiredArgsConstructor
@SuppressWarnings("unused")
@RequestMapping("/base")
@Slf4j
@Tag(name = "работа с базой", description = "Определение API")
public class APIController {
    private final SaveInDB saveInDB;
    private final GetCard getCard;
    private final GetAll getAll;

    @PostMapping(value = "/save")
    @Operation(summary = "сохранение данных сотрудников в базу")
    public ResponseEntity<Long> saveInDB(@Valid @RequestBody PersonDTO dto) {
        log.info("вызов /save/. Параметры: \"" + dto.toString());
        return ResponseEntity.ok(saveInDB.savePerson(dto));
    }
    @PostMapping(value = "/card/{id}")
    @Operation(summary = "получение карточки сотрудника по его ID")
    public ResponseEntity<EmployeeCardDTO> getCard(@RequestParam("id") Long applicationId) {
        log.info("вызов /card/{applicationId}. Параметры: \""  + applicationId);
        return new ResponseEntity<>(getCard.getCard(applicationId), HttpStatus.OK);
    }
    @PostMapping(value = "/guide")
    @Operation(summary = "получение списка всех сотрудников")
    public ResponseEntity<List<GuideDTO>> getGuide() {
        log.info("вызов /guide \"");
        return new ResponseEntity<>(getAll.getAll(), HttpStatus.OK);
    }

}
