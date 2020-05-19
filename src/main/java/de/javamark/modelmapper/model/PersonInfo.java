package de.javamark.modelmapper.model;

import lombok.Data;

import java.util.UUID;

@Data
public class PersonInfo {
    private UUID sourceId;
    private String fullName;
    private String city;

    private String ignorableProperty;
}
