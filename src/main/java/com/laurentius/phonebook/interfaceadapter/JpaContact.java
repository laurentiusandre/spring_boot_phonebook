package com.laurentius.phonebook.interfaceadapter;

import com.laurentius.phonebook.usecase.ContactCreateDsGateway;
import com.laurentius.phonebook.usecase.ContactDsRequestModel;

public class JpaContact implements ContactCreateDsGateway {

    final JpaContactRepository repository;

    public JpaContact(JpaContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void save(ContactDsRequestModel requestModel) {
        ContactDataMapper contactDataMapper = new ContactDataMapper(requestModel.getName(), requestModel.getNumber(), requestModel.getAddress(), requestModel.getEmail());
        repository.save(contactDataMapper);
    }
}
