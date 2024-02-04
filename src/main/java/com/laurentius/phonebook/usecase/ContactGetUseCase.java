package com.laurentius.phonebook.usecase;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactGateway;
import com.laurentius.phonebook.entity.ContactNotFoundException;

import java.util.List;

public class ContactGetUseCase {
    private final ContactGateway gateway;

    public ContactGetUseCase(ContactGateway gateway) {
        this.gateway = gateway;
    }

    public Contact get(Long id) throws ContactNotFoundException {
        return this.gateway.findById(id)
                .orElseThrow(ContactNotFoundException::new);
    }

    public List<Contact> getAll() {
        return this.gateway.findAll();
    }

    public List<Contact> search(String query) {
        return this.gateway.findByNameContaining(query);
    }
}
