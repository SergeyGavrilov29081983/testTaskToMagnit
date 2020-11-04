package ru.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParseEntries {


    @XmlElement(name = "entry")
    private List<ParseEntry> list = new ArrayList<>();

    public List<ParseEntry> getList() {
        return list;
    }

    public void setList(List<ParseEntry> list) {
        this.list = list;
    }
}

