package ru;

import ru.model.*;
import ru.repository.Repository;
import ru.util.XmlParser;
import ru.util.XmlTransform;
import ru.util.XmlWriter;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int n = 5;

    public static void main(String[] args) throws JAXBException, TransformerException {

        Repository repository = new Repository();
        repository.deleteAll();
        repository.saveAll(n);
        List<Model> models = repository.getAll();
        List<Integer> values = new ArrayList<>();

        for (Model model : models) {
            values.add(model.getField());
        }

        Entries entries = new Entries();
        XmlWriter writer = new XmlWriter();
        List<Entry> entriesList = entries.getList();

        for (Integer value : values) {
            Entry entry = new Entry(value);
            entriesList.add(entry);
        }

        writer.write("src/main/resources/1.xml", entries);

        XmlTransform xmlTransform = new XmlTransform();
        xmlTransform.transform();

        XmlParser parser = new XmlParser();
        ParseEntries parseEntries = parser.read("src/main/resources/2.xml");
        List<ParseEntry> parseEntriesList = parseEntries.getList();

        int sum = 0;
        for (ParseEntry parseEntry : parseEntriesList) {
            sum = sum + parseEntry.getField();
        }
        System.out.println(sum);
    }
}

