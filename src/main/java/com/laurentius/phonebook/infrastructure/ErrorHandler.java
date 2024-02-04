package com.laurentius.phonebook.infrastructure;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleError404(Exception e) {
        Map<String, String> map = new HashMap<>();
        map.put("errorMessage", e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
