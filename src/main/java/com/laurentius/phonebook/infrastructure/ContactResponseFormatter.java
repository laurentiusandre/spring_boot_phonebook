package com.laurentius.phonebook.infrastructure;

import com.laurentius.phonebook.usecase.ContactPresenter;
import com.laurentius.phonebook.usecase.IContactResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContactResponseFormatter implements ContactPresenter {

    @Override
    public IContactResponseDto prepareSuccessView(IContactResponseDto response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.createdDate());
        return new ContactResponseDto(response.name(), responseTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Override
    public IContactResponseDto prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
