package ru.podgoretskaya.employeeBase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.podgoretskaya.employeeBase.dto.*;
import ru.podgoretskaya.employeeBase.service.DirectoryService;
import ru.podgoretskaya.employeeBase.service.UserCardService;
import ru.podgoretskaya.employeeBase.service.SettlementService;
import ru.podgoretskaya.employeeBase.service.DBService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@SuppressWarnings("unused")
@RequestMapping("/base")
@Slf4j
@Tag(name = "работа с базой", description = "Определение API")
public class APIController {
    private final DBService DBService;
    private final UserCardService getCard;
    private final DirectoryService directoryService;
    private final SettlementService settlementService;

    @PostMapping(value = "/save")
    @Operation(summary = "сохранение данных сотрудников в базу")
    public ResponseEntity<String> saveInDB(@Valid @RequestBody PersonDTO dto) {
        log.info("\n>>>>>>>>> " + "вызов /save/. Параметры: \"" + dto.toString() + " <<<<<<<<<\n");
        return new ResponseEntity<>(DBService.savePerson(dto), HttpStatus.OK);
    }

    @PostMapping(value = "/card/{id}")
    @Operation(summary = "получение карточки сотрудника по его ID")
    public ResponseEntity<EmployeeCardDTO> getCard(@PathVariable("id") Long applicationId) {
        log.info("\n>>>>>>>>> " + "вызов /card/{applicationId}. Параметры: \"" + applicationId + " <<<<<<<<<\n");
        return new ResponseEntity<>(getCard.getCard(applicationId), HttpStatus.OK);
    }

    @GetMapping(value = "/guide")
    @Operation(summary = "получение списка всех сотрудников")
    public ResponseEntity<List<GuideDTO>> getGuide() {
        log.info("\n>>>>>>>>> " + "вызов /guide \"" + " <<<<<<<<<\n");
        return new ResponseEntity<>(directoryService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/daysOffWork/{id}")
    @Operation(summary = "сохранение отгула сотруднику")
    public void saveDaysOffWork(@Valid @RequestBody DayOff dto,@PathVariable("id") Long id) {
        log.info("\n>>>>>>>>> " + "вызов /daysOffWork/{id}. Параметры: \"" + dto.toString() + " " + id + " <<<<<<<<<\n");
        DBService.saveDayOff(dto, id);
    }

    @PostMapping(value = "/vacation/{id}")
    @Operation(summary = "сохранение отпуска сотруднику")
    public void saveVacation(@Valid @RequestBody Vacation dto, @PathVariable("id") Long id) {
        log.info("\n>>>>>>>>> " + "вызов /vacation/{id}. Параметры: \"" + dto.toString() + " " + id + " <<<<<<<<<\n");
        DBService.saveVacation(dto, id);
    }

    @PostMapping(value = "/sickDays/{id}")
    @Operation(summary = "сохранение больничного сотруднику")
    public void saveSickDays(@Valid @RequestBody SickDays dto, @PathVariable("id") Long id) {
        log.info("\n>>>>>>>>> " + "вызов //sickDays/{id}. Параметры: \"" + dto.toString() + " " + id + " <<<<<<<<<\n");
        DBService.saveSickDays(dto, id);
    }

    @PostMapping(value = "/getSettlement/{id}")
    @Operation(summary = "получение расчетки сотрудника")
    public ResponseEntity<AccountingDTO> getSettlement(@PathVariable("id") Long id) {
        log.info("\n>>>>>>>>> " + "вызов //getSettlement/{id}. Параметры: \"" + id + " <<<<<<<<<\n");
        return new ResponseEntity<>(settlementService.getSettlement(id), HttpStatus.OK);
    }

}