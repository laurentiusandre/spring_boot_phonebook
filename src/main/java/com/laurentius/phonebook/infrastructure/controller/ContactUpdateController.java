package com.laurentius.phonebook.infrastructure.controller;

import com.laurentius.phonebook.entity.ContactNotFoundException;
import com.laurentius.phonebook.infrastructure.ContactRequestDto;
import com.laurentius.phonebook.usecase.ContactUpdateUseCase;
import com.laurentius.phonebook.usecase.IContactResponseDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactUpdateController {

    private final ContactUpdateUseCase useCase;

    public ContactUpdateController(ContactUpdateUseCase useCase) {
        this.useCase = useCase;
    }

    @PutMapping("/{id}")
    IContactResponseDto update(@PathVariable Long id, @Valid @RequestBody ContactRequestDto requestModel) throws ContactNotFoundException {
        return useCase.update(id, requestModel);
    }
}
