package com.laurentius.phonebook.usecase;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactGateway;
import com.laurentius.phonebook.entity.ContactNotFoundException;
import com.laurentius.phonebook.infrastructure.ContactResponseDto;

import java.time.LocalDateTime;

public class ContactDeleteUseCase {
    private final ContactGateway gateway;
    private final ContactPresenter contactPresenter;

    public ContactDeleteUseCase(ContactGateway gateway, ContactPresenter contactPresenter) {
        this.gateway = gateway;
        this.contactPresenter = contactPresenter;
    }

    public IContactResponseDto delete(Long id) {
        Contact contact = this.gateway.findById(id)
                .orElseThrow(ContactNotFoundException::new);

        LocalDateTime now = LocalDateTime.now();
        this.gateway.deleteById(id);

        return contactPresenter.prepareSuccessView(new ContactResponseDto(contact.getName(), now.toString()));
    }
}
