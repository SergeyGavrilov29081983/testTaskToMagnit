package ru.model;


import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Model implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private int field;

    public Model() {
    }

    public Model(int field) {
        this(UUID.randomUUID().toString(), field);
    }

    public Model(String id, int field) {
        Objects.requireNonNull(id, "d must not be null");
        this.id = id;
        this.field = field;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }
}
