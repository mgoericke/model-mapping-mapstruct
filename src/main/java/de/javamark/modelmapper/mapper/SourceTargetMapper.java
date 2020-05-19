package de.javamark.modelmapper.mapper;

import de.javamark.modelmapper.model.Person;
import de.javamark.modelmapper.model.PersonInfo;
import de.javamark.modelmapper.model.Source;
import de.javamark.modelmapper.model.Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SourceTargetMapper {
    SourceTargetMapper MAPPER = Mappers.getMapper(SourceTargetMapper.class);

    @Mappings(
            @Mapping(source = "stringProperty", target = "longProperty")
    )
    Target toTarget(Source source);

}
