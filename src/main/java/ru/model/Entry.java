package ru.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

    @XmlElement(name = "field")
    private int field;

    public Entry(int field) {
        this.field = field;
    }
}
