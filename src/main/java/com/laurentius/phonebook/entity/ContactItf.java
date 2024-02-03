package com.laurentius.phonebook.entity;

public interface ContactItf {
    boolean nameIsValid();

    String getName();

    String getNumber();

    String getAddress();

    String getEmail();
}
