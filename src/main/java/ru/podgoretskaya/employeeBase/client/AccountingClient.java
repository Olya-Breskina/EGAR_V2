package ru.podgoretskaya.employeeBase.client;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.podgoretskaya.employeeBase.dto.AccountingDTO;
import ru.podgoretskaya.employeeBase.dto.CalculationDTO;
import ru.podgoretskaya.employeeBase.dto.PersonDTO;

@FeignClient(name = "accounting", url = "http://localhost:8081/accounting")
public interface AccountingClient {
    @PostMapping(value = "/getCard")
    ResponseEntity<PersonDTO> getCard(@Valid @RequestBody PersonDTO model);

    @PostMapping(value = "/account")
    ResponseEntity<AccountingDTO> getSettlement(@Valid @RequestBody CalculationDTO model);
}
