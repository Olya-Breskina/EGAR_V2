package ru.podgoretskaya.employeeBase.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import ru.podgoretskaya.employeeBase.dto.PersonDTO;
import ru.podgoretskaya.employeeBase.entity.PersonEntity;
import ru.podgoretskaya.employeeBase.mapper.AccountingMap;
import ru.podgoretskaya.employeeBase.mapper.DaysOffWorkMap;
import ru.podgoretskaya.employeeBase.mapper.PersonMap;
import ru.podgoretskaya.employeeBase.repository.AccountingRepo;
import ru.podgoretskaya.employeeBase.repository.DaysOffWorkRepo;
import ru.podgoretskaya.employeeBase.repository.PersonRepo;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService implements SaveInDB {
    private final PersonMap personMap;
    private final PersonRepo personRepo;
    private final AccountingMap accountingMap;
    private final AccountingRepo accountingRepo;
    private final DaysOffWorkMap daysOffWorkMap;
    private final DaysOffWorkRepo daysOffWorkRepo;

    @Override
    public Long savePerson(PersonDTO dto) {
        PersonEntity personentity;
        try {
            personentity = personRepo.save(personMap.toEntity(dto));
            return personentity.getPersonID();
        } catch (HttpMessageNotReadableException e){
            return Long.valueOf(0);
        }
    }
}
   /* private void saveApplicationToDB(LoanApplicationRequestDTO model) {
        ApplicationEntity applicationEntity = new ApplicationEntity();
        ClientEntity clientEntity = clientMapper.loanApplicationRequestDTOMapToEntity(model);
        clientRepo.save(clientEntity);
        CreditEntity creditEntity = creditMapper.loanApplicationRequestDTOMapToEntity(model);
        creditRepo.save(creditEntity);
        applicationEntity.setClient(clientEntity);
        applicationEntity.setCredit(creditEntity);
        HistiryManagerUtil.updateStatus(applicationEntity, PREAPPROVAL);
        applicationRepo.save(applicationEntity);
    }
    */
