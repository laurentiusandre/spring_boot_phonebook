package com.laurentius.phonebook.infrastructure;

import com.laurentius.phonebook.usecase.IContactResponseDto;

public record ContactResponseDto(

        String name,
        String createdDate
) implements IContactResponseDto { }
