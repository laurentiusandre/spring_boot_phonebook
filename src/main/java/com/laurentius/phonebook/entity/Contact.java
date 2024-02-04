package com.laurentius.phonebook.entity;

import java.time.LocalDateTime;

public class Contact {

    private Long id;
    private String name;
    private String number;
    private String address;
    private String email;
    private LocalDateTime createdDate;

    public Contact() {
    }

    public Contact(String name, String number, String address, String email) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
    }

    public Contact(String name, String number, String address, String email, LocalDateTime createdDate) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
        this.createdDate = createdDate;
    }

    public Contact(Long id, String name, String number, String address, String email, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
