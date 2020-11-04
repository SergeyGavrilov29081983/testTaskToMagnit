package ru.model;

import javax.persistence.*;

@Entity(name = "Model")
@Table(name = "test")
public class Model {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "field")
    private int field;

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }
}
