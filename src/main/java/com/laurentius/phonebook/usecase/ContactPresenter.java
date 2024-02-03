package com.laurentius.phonebook.usecase;

public interface ContactPresenter {
    ContactResponseModel prepareSuccessView(ContactResponseModel contact);

    ContactResponseModel prepareFailView(String error);
}