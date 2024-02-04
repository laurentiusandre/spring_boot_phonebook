package com.laurentius.phonebook.infrastructure;

import com.laurentius.phonebook.usecase.IContactDto;
import jakarta.validation.constraints.NotBlank;

public record ContactRequestDto(

    @NotBlank String name,
    String number,
    String address,
    String email
) implements IContactDto { }
