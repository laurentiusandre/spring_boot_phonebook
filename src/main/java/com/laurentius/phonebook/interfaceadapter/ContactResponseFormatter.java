package com.laurentius.phonebook.interfaceadapter;

import com.laurentius.phonebook.usecase.ContactPresenter;
import com.laurentius.phonebook.usecase.ContactResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContactResponseFormatter implements ContactPresenter {

    @Override
    public ContactResponseModel prepareSuccessView(ContactResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreatedDate());
        response.setCreatedDate(responseTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return response;
    }

    @Override
    public ContactResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
