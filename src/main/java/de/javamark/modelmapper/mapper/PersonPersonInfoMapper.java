package de.javamark.modelmapper.mapper;

import de.javamark.modelmapper.model.Person;
import de.javamark.modelmapper.model.PersonInfo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonPersonInfoMapper {
    PersonPersonInfoMapper MAPPER = Mappers.getMapper(PersonPersonInfoMapper.class);

    @Mapping(target = "fullName", expression = "java(person.getFirstName() + \" \" +  person.getLastName())")
    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "sourceId", source = "id", defaultExpression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "ignorableProperty", ignore = true)
    PersonInfo toPersonDTO(Person person);

    @AfterMapping
    default void afterMapping(@MappingTarget final PersonInfo personInfo, final Person person) {
        personInfo.setIgnorableProperty("IGNORABLE");
    }
}