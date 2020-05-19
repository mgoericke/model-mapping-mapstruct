package de.javamark.modelmapper.mapper;

import de.javamark.modelmapper.model.Source;
import de.javamark.modelmapper.model.Target;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SourceTargetMapperTest {

    @Test
    void shouldMapStringPropertyToLongProperty() {
        Source source = new Source();
        source.setStringProperty("12345");

        Target target = SourceTargetMapper.MAPPER.toTarget(source);

        assertEquals(12345, (long) target.getLongProperty());
    }
}