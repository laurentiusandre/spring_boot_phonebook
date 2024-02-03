package com.laurentius.phonebook.usecase;

import com.laurentius.phonebook.entity.ContactItf;
import com.laurentius.phonebook.entity.ContactItfFactory;

import java.time.LocalDateTime;

public class ContactCreateInteractor implements ContactInputBoundary {

    final ContactCreateDsGateway contactDsGateway;
    final ContactPresenter contactPresenter;
    final ContactItfFactory contactItfFactory;

    public ContactCreateInteractor(ContactCreateDsGateway contactDsGateway, ContactPresenter contactPresenter, ContactItfFactory contactItfFactory) {
        this.contactDsGateway = contactDsGateway;
        this.contactPresenter = contactPresenter;
        this.contactItfFactory = contactItfFactory;
    }

    @Override
    public ContactResponseModel create(ContactRequestModel requestModel) {
        if (contactDsGateway.existsById(requestModel.getId())) {
            return contactPresenter.prepareFailView("Contact already exists.");
        }
        ContactItf contactItf = contactItfFactory.create(requestModel.getName(), requestModel.getNumber(), requestModel.getAddress(), requestModel.getEmail());
        if (!contactItf.nameIsValid()) {
            return contactPresenter.prepareFailView("Name must not be empty.");
        }
        LocalDateTime now = LocalDateTime.now();
        ContactDsRequestModel contactDsModel = new ContactDsRequestModel(contactItf.getName(), contactItf.getNumber(), contactItf.getAddress(), contactItf.getEmail(), now);

        contactDsGateway.save(contactDsModel);

        ContactResponseModel contactResponseModel = new ContactResponseModel(contactItf.getName(), now.toString());
        return contactPresenter.prepareSuccessView(contactResponseModel);
    }
}