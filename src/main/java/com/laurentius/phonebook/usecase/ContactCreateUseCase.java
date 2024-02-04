package com.laurentius.phonebook.usecase;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactGateway;

import java.time.LocalDateTime;

public class ContactCreateUseCase {
    private final ContactGateway gateway;
    private final ContactPresenter contactPresenter;

    public ContactCreateUseCase(ContactGateway gateway, ContactPresenter contactPresenter) {
        this.gateway = gateway;
        this.contactPresenter = contactPresenter;
    }

    public ContactResponseModel create(IContactDto requestModel) {
        LocalDateTime now = LocalDateTime.now();
        Contact contactDsModel = new Contact(requestModel.name(), requestModel.number(), requestModel.address(), requestModel.email(), now);
        gateway.save(contactDsModel);

        return contactPresenter.prepareSuccessView(new ContactResponseModel(requestModel.name(), now.toString()));
    }
}
