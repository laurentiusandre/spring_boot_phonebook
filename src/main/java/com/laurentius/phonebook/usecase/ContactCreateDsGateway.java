package com.laurentius.phonebook.usecase;

public interface ContactCreateDsGateway {
    boolean existsById(Long id);

    void save(ContactDsRequestModel requestModel);
}
