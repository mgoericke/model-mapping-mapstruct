package de.javamark.modelmapper.mapper;

import de.javamark.modelmapper.model.Address;
import de.javamark.modelmapper.model.Person;
import de.javamark.modelmapper.model.PersonInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonPersonInfoMapperTest {

    Person person;

    @BeforeEach
    void setUp() {
        this.person = new Person();
        this.person.setFirstName("Mark");
        this.person.setLastName("Göricke");

        final Address address = new Address();
        address.setCity("Berlin");
        address.setZipCode(10243);
        this.person.setAddress(address);
    }

    @Test
    void mapSourceNestedPropertyToTargetProperty() {
        final PersonInfo personInfo = PersonPersonInfoMapper.MAPPER.toPersonDTO(this.person);
        assertEquals("Berlin", personInfo.getCity());
    }

    @Test
    void concatenateSourcePropertiesToSingleTargetProperty() {
        final PersonInfo personInfo = PersonPersonInfoMapper.MAPPER.toPersonDTO(this.person);
        assertEquals("Mark Göricke", personInfo.getFullName());
    }

    @Test
    void testMissingSourceIdIsCreatedUsingDefaultExpression() {
        final PersonInfo personInfo = PersonPersonInfoMapper.MAPPER.toPersonDTO(this.person);
        assertNotNull(personInfo.getSourceId());
    }

    @Test
    void testIgnorablePropertyIsSetInAfterMapping() {
        final PersonInfo personInfo = PersonPersonInfoMapper.MAPPER.toPersonDTO(this.person);
        assertEquals("IGNORABLE", personInfo.getIgnorableProperty());
    }
}