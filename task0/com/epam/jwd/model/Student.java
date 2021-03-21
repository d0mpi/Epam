package com.epam.jwd.model;

import java.util.Objects;

public class Student {
    private final long id;
    private final String name;
    private String university;

    public Student(long id, String name, String university) {
        this.id = id;
        this.name = name;
        this.university = university;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && name.equals(student.name) && university.equals(student.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, university);
    }

    @Override
    public String toString() {
        return "Student: " + id +
                ", name='" + name + '\'' +
                ", university='" + university + '\'';
    }
}
