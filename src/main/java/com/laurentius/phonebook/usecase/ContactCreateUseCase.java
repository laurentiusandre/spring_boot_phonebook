package com.laurentius.phonebook.usecase;

import java.time.LocalDateTime;

public class ContactCreateUseCase {
    private final ContactCreateDsGateway gateway;
    private final ContactPresenter contactPresenter;

    public ContactCreateUseCase(ContactCreateDsGateway gateway, ContactPresenter contactPresenter) {
        this.gateway = gateway;
        this.contactPresenter = contactPresenter;
    }

    public ContactResponseModel create(IContactDto requestModel) {
        LocalDateTime now = LocalDateTime.now();
        ContactDsRequestModel contactDsModel = new ContactDsRequestModel(requestModel.name(), requestModel.number(), requestModel.address(), requestModel.email(), now);
        gateway.save(contactDsModel);

        return contactPresenter.prepareSuccessView(new ContactResponseModel(requestModel.name(), now.toString()));
    }
}
