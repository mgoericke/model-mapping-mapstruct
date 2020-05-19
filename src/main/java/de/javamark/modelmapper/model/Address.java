package de.javamark.modelmapper.model;

import lombok.Data;

@Data
public class Address {
    private String street;
    private Long houseNumber;
    private Integer zipCode;
    private String city;
}
