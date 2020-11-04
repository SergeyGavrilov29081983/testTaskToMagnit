package ru.model;


import javax.xml.bind.annotation.*;


@XmlType(propOrder = {"entry", "field"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ParseEntry {

    @XmlElement(name = "entry")
    private String entry;

    @XmlAttribute(name = "field")
    private int field;

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
