package com.laurentius.phonebook.usecase;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactGateway;
import com.laurentius.phonebook.infrastructure.ContactResponseDto;

import java.time.LocalDateTime;

public class ContactCreateUseCase {
    private final ContactGateway gateway;
    private final ContactPresenter contactPresenter;

    public ContactCreateUseCase(ContactGateway gateway, ContactPresenter contactPresenter) {
        this.gateway = gateway;
        this.contactPresenter = contactPresenter;
    }

    public IContactResponseDto create(IContactRequestDto requestModel) {
        LocalDateTime now = LocalDateTime.now();
        Contact contact = new Contact(requestModel.name(), requestModel.number(), requestModel.address(), requestModel.email(), now);
        this.gateway.save(contact);

        return contactPresenter.prepareSuccessView(new ContactResponseDto(requestModel.name(), now.toString()));
    }
}
