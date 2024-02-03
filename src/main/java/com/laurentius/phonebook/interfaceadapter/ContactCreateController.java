package com.laurentius.phonebook.interfaceadapter;

import com.laurentius.phonebook.usecase.ContactInputBoundary;
import com.laurentius.phonebook.usecase.ContactRequestModel;
import com.laurentius.phonebook.usecase.ContactResponseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class ContactCreateController {

    final ContactInputBoundary contactInput;

    public ContactCreateController(ContactInputBoundary contactInput) {
        this.contactInput = contactInput;
    }

    @PostMapping("/contact")
    ContactResponseModel create(@RequestBody ContactRequestModel requestModel) {
        return contactInput.create(requestModel);
    }
}
