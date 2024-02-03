package com.laurentius.phonebook.entity;

public class ContactFactory implements ContactItfFactory {
    @Override
    public ContactItf create(String name, String number, String address, String email) {
        return new Contact(name, number, address, email);
    }
}
