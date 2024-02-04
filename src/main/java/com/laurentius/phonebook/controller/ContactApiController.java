package com.laurentius.phonebook.controller;

import com.laurentius.phonebook.interfaceadapter.ContactDataMapper;
import com.laurentius.phonebook.interfaceadapter.JpaContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
//@RequestMapping("/api/contact")
@RequestMapping("/oldcontroller")
public class ContactApiController {

    @Autowired
    private JpaContactRepository repository;

    @GetMapping
    public List<ContactDataMapper> getContacts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ContactDataMapper getContact(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createContact(@RequestBody ContactDataMapper contact) throws URISyntaxException {
        ContactDataMapper savedContact = repository.save(contact);
        return ResponseEntity.created(new URI("/contact/" + savedContact.getId())).body(savedContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateContact(@PathVariable Long id, @RequestBody ContactDataMapper contact) {
        ContactDataMapper currentContact = repository.findById(id).orElseThrow(RuntimeException::new);
        currentContact.setName(contact.getName());
        currentContact.setNumber(contact.getNumber());
        currentContact.setAddress(contact.getAddress());
        currentContact.setEmail(contact.getEmail());
        currentContact = repository.save(currentContact);

        return ResponseEntity.ok(currentContact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContact(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
