package com.laurentius.phonebook.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaContactRepository extends JpaRepository<ContactDataMapper, Long> {
    Optional<ContactDataMapper> findById(final Long id);
    List<ContactDataMapper> findAll();
    List<ContactDataMapper> findByName(final String name);
    List<ContactDataMapper> findByNumber(final String number);
    List<ContactDataMapper> findByNameContaining(final String number);
}
