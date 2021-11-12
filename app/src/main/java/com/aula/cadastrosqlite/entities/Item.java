package com.aula.cadastrosqlite.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Item implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int Id;
    private String fieldone;
    private String fieldtwo;
    private String fieldthree;

    public Item(){ }

    @Ignore
    public Item(int id, String fieldone, String fieldtwo, String fieldthree) {
        Id = id;
        this.fieldone = fieldone;
        this.fieldtwo = fieldtwo;
        this.fieldthree = fieldthree;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFieldone() {
        return fieldone;
    }

    public void setFieldone(String fieldone) {
        this.fieldone = fieldone;
    }

    public String getFieldtwo() {
        return fieldtwo;
    }

    public void setFieldtwo(String fieldtwo) {
        this.fieldtwo = fieldtwo;
    }

    public String getFieldthree() {
        return fieldthree;
    }

    public void setFieldthree(String fieldthree) {
        this.fieldthree = fieldthree;
    }
}
