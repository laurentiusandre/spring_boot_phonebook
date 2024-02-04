package com.laurentius.phonebook.usecase;

import jakarta.validation.constraints.NotBlank;

public record ContactRequestModel(

    @NotBlank String name,
    String number,
    String address,
    String email
) implements IContactDto { }
