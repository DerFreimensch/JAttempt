package com.example.model;

import javafx.beans.property.*;

public class Student {
    private StringProperty name;
    private StringProperty secondname;
    private IntegerProperty age;
    private StringProperty group;

    public Student(String name, String secondname, int age, String group) {
        this.name = new SimpleStringProperty(name);
        this.secondname = new SimpleStringProperty(secondname);
        this.age = new SimpleIntegerProperty(age);
        this.group = new SimpleStringProperty(group);
    }

    public Student() {
        name = new SimpleStringProperty();
        secondname = null;
        age = null;
        group = null;
    }

    public void setName(SimpleStringProperty Name) {
        this.name  = Name;
    }

    public IntegerProperty getAge() {
        return age;
    }

    public StringProperty getName() {
        return name;
    }

    public StringProperty getSecondname() {
        return secondname;
    }

    public StringProperty getGroup() {
        return group;
    }

    public StringProperty getFullName(){
        return new SimpleStringProperty(secondname.getValue() + " " + name.getValue());
    }

    public void setSecondName(SimpleStringProperty secondName) { this.secondname = secondName; }
}
