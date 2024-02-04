package com.laurentius.phonebook.infrastructure;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactNotFoundException;
import com.laurentius.phonebook.usecase.ContactGetUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
