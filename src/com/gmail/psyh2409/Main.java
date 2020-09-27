package com.gmail.psyh2409;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(Sex.male, "", "First", 0, 1);
        Student student2 = new Student(Sex.valueOf("female"), "", "Second", 100500, 2);
        Student student3 = new Student("Third", 3);
        Student student4 = new Student("Fourth", 4);
        Student student5 = new Student("Fifth", 5);
        Student student6 = new Student("Sixth", 6);
        Student student7 = new Student("Seventh", 7);
        Student student8 = new Student("Eighth", 8);
        Student student9 = new Student("Ninth", 9);
        Student student10 = new Student("Tenth", 10);
        Student student11 = new Student("Eleventh", 11);

        Group group = new Group(new Student[]{student1, null, student3, student4, student5,
                student6, student7, student8, student9, student10});

        System.out.println("Students' group.");
        for (Student student : group.getStudents()) {
            System.out.println(student);
        }

        group.removeStudent(9);
        System.out.println();
        System.out.println("group.removeStudent(9);");
        for (Student student : group.getStudents()) {
            System.out.println(student);
        }

        System.out.println();
        System.out.println("group.findStudent(\"Eighth\")");
        String string = "Student doesn't exist.";
        Student student = group.findStudent("Eighth");
        System.out.println(student == null ? string : student);
        System.out.println("group.findStudent(\"Ninth\")");
        student = group.findStudent("Ninth");
        System.out.println(student == null ? string : student);


        System.out.println();
        System.out.println("group.addStudent(student11);");
        try {
            group.addStudent(student11);
        } catch (RedundantStudentException rse) {
            System.out.println(rse.getMessage());
        }

        System.out.println();
        System.out.println("group.toString();");
        System.out.println(group);

        System.out.println();
        System.out.println("group.addStudent(student9);");
        try {
            group.addStudent(student9);
        } catch (RedundantStudentException rse) {
            System.out.println(rse.getMessage());
            rse.printStackTrace();
        }

        System.out.println();
        System.out.println("group.addStudent(student2); // Must be redundant.");
        try {
            group.addStudent(student2);  // Must be redundant.
        } catch (RedundantStudentException rse) {
            System.out.println(rse.getMessage());
            rse.printStackTrace();
        }

        System.out.println();
        System.out.println("group.toString();");
        System.out.println(group);


    }

}
