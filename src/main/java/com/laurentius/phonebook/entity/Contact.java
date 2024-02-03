package com.laurentius.phonebook.entity;

import com.laurentius.phonebook.util.StringUtil;

public class Contact implements ContactItf {

    private Long id;
    private String name;
    private String number;
    private String address;
    private String email;

    public Contact() {
    }

    public Contact(Long id, String name, String number, String address, String email) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
    }

    public Contact(String name, String number, String address, String email) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean nameIsValid() {
        return !StringUtil.isBlank(name);
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

