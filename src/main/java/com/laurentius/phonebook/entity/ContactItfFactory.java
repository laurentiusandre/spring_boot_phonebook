package com.laurentius.phonebook.entity;

public interface ContactItfFactory {
    ContactItf create(String name, String number, String address, String email);
}
