package com.skillnext1;

public class Student {

    private int id;
    private String name;
    private int semester;
    private String department;

    public Student(String name, int semester, String department) {
        this.name = name;
        this.semester = semester;
        this.department = department;
    }

    public Student(int id, String name, int semester, String department) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | Sem: " + semester + " | Dept: " + department;
    }
}
