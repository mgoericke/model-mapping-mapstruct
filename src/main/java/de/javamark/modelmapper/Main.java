package de.javamark.modelmapper;

import de.javamark.modelmapper.model.Source;
import de.javamark.modelmapper.mapper.SourceTargetMapper;
import de.javamark.modelmapper.model.Target;

public class Main {

    public static void main(String[] args) {

        Source source = new Source();
        source.setStringProperty("55");

        Target target = SourceTargetMapper.MAPPER.toTarget(source);
        System.out.println("[+] source " + source.toString() + " successfully mapped to target: " + target.toString());
    }

}
