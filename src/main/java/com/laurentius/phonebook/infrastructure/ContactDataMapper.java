package com.laurentius.phonebook.infrastructure;

import com.laurentius.phonebook.entity.Contact;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contact")
public class ContactDataMapper {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name="created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    public ContactDataMapper() {
    }

    public ContactDataMapper(Long id, String name, String number, String address, String email) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
    }

    public ContactDataMapper(String name, String number, String address, String email) {
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
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

    public Contact toContact() {
        return new Contact(
                this.getId(),
                this.getName(),
                this.getNumber(),
                this.getAddress(),
                this.getEmail(),
                LocalDateTime.now()
        );
    }
}


