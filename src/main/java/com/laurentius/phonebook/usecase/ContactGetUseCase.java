package com.laurentius.phonebook.usecase;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactGateway;
import com.laurentius.phonebook.entity.ContactNotFoundException;

public class ContactGetUseCase {
    private final ContactGateway gateway;

    public ContactGetUseCase(ContactGateway gateway) {
        this.gateway = gateway;
    }

    public Contact get(Long id) throws ContactNotFoundException {
        return this.gateway.findById(id)
                .orElseThrow(ContactNotFoundException::new);
    }
}
