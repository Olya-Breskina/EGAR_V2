package ru.podgoretskaya.employeeBase.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class ServiceException {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> newException(NoSuchElementException e) {
        log.error(e.getMessage(), e);
        String apiError = new String("В базе данных нет записи с таким id");
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> newException(HttpMessageNotReadableException e) {
        log.error(e.getMessage(), e);
        String apiError = new String("Данные не сохранены. Проверьте корректность введенных данных и попробуйте снова");
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
