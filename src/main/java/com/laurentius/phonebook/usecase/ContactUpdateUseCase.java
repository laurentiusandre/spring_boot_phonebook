package com.laurentius.phonebook.usecase;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactGateway;
import com.laurentius.phonebook.entity.ContactNotFoundException;
import com.laurentius.phonebook.infrastructure.ContactResponseDto;

import java.time.LocalDateTime;

public class ContactUpdateUseCase {
    private final ContactGateway gateway;
    private final ContactPresenter contactPresenter;

    public ContactUpdateUseCase(ContactGateway gateway, ContactPresenter contactPresenter) {
        this.gateway = gateway;
        this.contactPresenter = contactPresenter;
    }

    public IContactResponseDto update(Long id, IContactRequestDto requestModel) throws ContactNotFoundException {
        Contact contact = this.gateway.findById(id).orElseThrow(ContactNotFoundException::new);

        LocalDateTime now = LocalDateTime.now();
        contact.setName(requestModel.name());
        contact.setNumber(requestModel.number());
        contact.setAddress(requestModel.address());
        contact.setEmail(requestModel.email());
        this.gateway.save(contact);

        return contactPresenter.prepareSuccessView(new ContactResponseDto(requestModel.name(), now.toString()));
    }
}
