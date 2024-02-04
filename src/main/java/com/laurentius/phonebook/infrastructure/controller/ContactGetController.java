package com.laurentius.phonebook.infrastructure.controller;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactNotFoundException;
import com.laurentius.phonebook.usecase.ContactGetUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactGetController {

    private final ContactGetUseCase useCase;

    public ContactGetController(ContactGetUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/{id}")
    Contact get(@PathVariable Long id) throws ContactNotFoundException {
        return useCase.get(id);
    }

    @GetMapping
    List<Contact> getAll() {
        return useCase.getAll();
    }
}
