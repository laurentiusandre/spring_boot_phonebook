package com.laurentius.phonebook.entity;

import java.util.List;
import java.util.Optional;

public interface ContactGateway {
    boolean existsById(Long id);

    void save(Contact requestModel);
    void deleteById(Long id);
    Optional<Contact> findById(Long id);
    List<Contact> findAll();
}
