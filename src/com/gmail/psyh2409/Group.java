package com.gmail.psyh2409;

import java.util.Arrays;

public class Group {
    private Student[] students;

    public Group() {
        super();
        this.students = new Student[10];
    }

    public Group(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Arrays.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(students);
    }

    @Override
    public String toString() {
        sortBySurname();
        StringBuilder sortedBySurname = new StringBuilder("Group{");
        if (students == null) {
            return "Group doesn't exist.";
        }
        for (int i = 0; i < students.length; i++) {
            sortedBySurname.append("\n\t").append(students[i]);
        }
        sortedBySurname.append("}");
        return sortedBySurname.toString();
    }

    public boolean addStudent(Student student) throws RedundantStudentException {
        if (student == null || students == null) return false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return true;
            }
            if (i == students.length - 1) throw new RedundantStudentException();
        }
        return false;
    }

    public boolean removeStudent(long recordBook) {
        if (students == null) return false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) continue;
            if (students[i].getRecordBookId() == recordBook) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    public Student findStudent(String surname) {
        if (surname == null || students == null) {
            return null;
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) continue;
            if (students[i].getSurname().equals(surname)) {
                return students[i];
            }
        }
        return null;
    }

    private void sortBySurname() {
        Student temp;
        sortByNull();
        if (students == null) return;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) break;
            for (int j = i + 1; j < students.length; j++) {
                if (students[j] == null) break;
                if (students[i].getSurname().compareTo(students[j].getSurname()) > 0) {
                    temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    private void sortByNull() {
        if (students == null) return;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                for (int j = i + 1; j < students.length; j++) {
                    if (students[j] == null) continue;
                    students[i] = students[j];
                    if (j == students.length - 1 && students[i].equals(students[j])) {
                        students[j] = null;
                    }
                }
            }
        }
    }
}
