package de.javamark.modelmapper.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Person {
    private UUID id;
    private String firstName;
    private String lastName;
    private Address address;
}
