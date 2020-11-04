package ru.util;

import ru.model.ParseEntries;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlParser {

    public ParseEntries read(String file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ParseEntries.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (ParseEntries) jaxbUnmarshaller.unmarshal(new File(file));
    }
}
