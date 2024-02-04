package com.laurentius.phonebook.infrastructure.controller;

import com.laurentius.phonebook.entity.ContactNotFoundException;
import com.laurentius.phonebook.usecase.ContactDeleteUseCase;
import com.laurentius.phonebook.usecase.IContactResponseDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactDeleteController {

    private final ContactDeleteUseCase useCase;

    public ContactDeleteController(ContactDeleteUseCase useCase) {
        this.useCase = useCase;
    }

    @DeleteMapping("/{id}")
    IContactResponseDto delete(@PathVariable Long id) throws ContactNotFoundException {
        return useCase.delete(id);
    }
}
