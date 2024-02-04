package com.laurentius.phonebook.infrastructure;

import com.laurentius.phonebook.usecase.ContactCreateUseCase;
import com.laurentius.phonebook.usecase.ContactResponseModel;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactCreateController {

    private final ContactCreateUseCase useCase;

    public ContactCreateController(ContactCreateUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    ContactResponseModel create(@Valid @RequestBody ContactRequestDto requestModel) {
        return useCase.create(requestModel);
    }
}
