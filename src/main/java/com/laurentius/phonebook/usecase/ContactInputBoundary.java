package com.laurentius.phonebook.usecase;

public interface ContactInputBoundary {
    ContactResponseModel create(ContactRequestModel requestModel);
}
