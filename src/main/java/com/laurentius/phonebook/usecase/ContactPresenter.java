package com.laurentius.phonebook.usecase;

public interface ContactPresenter {
    IContactResponseDto prepareSuccessView(IContactResponseDto contact);

    IContactResponseDto prepareFailView(String error);
}