package com.laurentius.phonebook.infrastructure;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactGateway;

import java.util.List;
import java.util.Optional;

public class ContactDatabaseGateway implements ContactGateway {

    final JpaContactRepository repository;

    public ContactDatabaseGateway(JpaContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void save(Contact requestModel) {
        ContactDataMapper contactDataMapper = new ContactDataMapper(requestModel.getName(), requestModel.getNumber(), requestModel.getAddress(), requestModel.getEmail());
        repository.save(contactDataMapper);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return repository.findById(id).map(ContactDataMapper::toContact);
    }

    @Override
    public List<Contact> findAll() {
        return repository.findAll()
                .stream()
                .map(ContactDataMapper::toContact)
                .toList();
    }
}
