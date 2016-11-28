package com.yubarj.model;

/**
 * Created by yubraj on 11/27/16.
 */

public class Person {
    private int id;
    private String first_name;
    private String last_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (!first_name.equals(person.first_name)) return false;
        return last_name.equals(person.last_name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + first_name.hashCode();
        result = 31 * result + last_name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
