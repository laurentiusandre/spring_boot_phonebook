package com.laurentius.phonebook.usecase;

import java.time.LocalDateTime;

public class ContactResponseModel {

    private String name;
    private String createdDate;

    public ContactResponseModel() {
    }

    public ContactResponseModel(String name, String createdDate) {
        this.name = name;
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
