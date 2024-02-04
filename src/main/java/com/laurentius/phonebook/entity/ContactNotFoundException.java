package com.laurentius.phonebook.entity;

import jakarta.persistence.EntityNotFoundException;

public class ContactNotFoundException extends EntityNotFoundException {
    public ContactNotFoundException() {
        super("Contact not found");
    }
}
