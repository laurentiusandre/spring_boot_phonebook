package com.laurentius.phonebook.usecase;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactGateway;
import com.laurentius.phonebook.infrastructure.ContactResponseDto;

import java.time.LocalDateTime;

public class ContactUpdateUseCase {
    private final ContactGateway gateway;
    private final ContactPresenter contactPresenter;

    public ContactUpdateUseCase(ContactGateway gateway, ContactPresenter contactPresenter) {
        this.gateway = gateway;
        this.contactPresenter = contactPresenter;
    }

    public IContactResponseDto update(Long id, IContactRequestDto requestModel) {
        LocalDateTime now = LocalDateTime.now();
        Contact contact = new Contact(id, requestModel.name(), requestModel.number(), requestModel.address(), requestModel.email(), now);
        gateway.save(contact);

        return contactPresenter.prepareSuccessView(new ContactResponseDto(requestModel.name(), now.toString()));
    }
}
