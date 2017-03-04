package com.epam.mentoring.lesstwo;

/**
 * Created by Aliaksandr_Liahushau on 3/4/2017.
 */
public class Person {
    String name;

    public Person(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) { this.name = name; }

    @Override
    public String toString() {
        return "{ \"name\": " + "\"" + this.name + "\"}";
    }
}

