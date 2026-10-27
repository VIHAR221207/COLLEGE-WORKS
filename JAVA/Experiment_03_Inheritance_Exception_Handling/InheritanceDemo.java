/*
 * Experiment 3: Programs on Various Types of Inheritance and Exception Handling
 * Demonstrating Single, Multilevel, and Hierarchical Inheritance
 */

import java.util.Scanner;

// Base Class
class Person {
    String name;
    int age;

    void inputPerson(Scanner sc) {
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Age: ");
        age = sc.nextInt();
        sc.nextLine();
    }

    void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// 1. Single Inheritance (Student extends Person)
class Student extends Person {
    String course;
    int rollNumber;

    void inputStudent(Scanner sc) {
        inputPerson(sc);
        System.out.print("Enter Course: ");
        course = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        rollNumber = sc.nextInt();
        sc.nextLine();
    }

    void displayStudent() {
        displayPerson();
        System.out.println("Course: " + course);
        System.out.println("Roll Number: " + rollNumber);
    }
}

// 2. Multilevel Inheritance (GraduateStudent extends Student)
class GraduateStudent extends Student {
    int graduationYear;

    void inputGradStudent(Scanner sc) {
        inputStudent(sc);
        System.out.print("Enter Graduation Year: ");
        graduationYear = sc.nextInt();
        sc.nextLine();
    }

    void displayGradStudent() {
        displayStudent();
        System.out.println("Graduation Year: " + graduationYear);
    }
}

// 3. Hierarchical Inheritance (Teacher extends Person)
class Teacher extends Person {
    String subject;
    double salary;

    void inputTeacher(Scanner sc) {
        inputPerson(sc);
        System.out.print("Enter Subject: ");
        subject = sc.nextLine();
        System.out.print("Enter Salary: ");
        salary = sc.nextDouble();
        sc.nextLine();
    }

    void displayTeacher() {
        displayPerson();
        System.out.println("Subject: " + subject);
        System.out.println("Salary: " + salary);
    }
}

// 3. Hierarchical Inheritance (Administrator extends Person)
class Administrator extends Person {
    String department;
    String role;

    void inputAdmin(Scanner sc) {
        inputPerson(sc);
        System.out.print("Enter Department: ");
        department = sc.nextLine();
        System.out.print("Enter Role: ");
        role = sc.nextLine();
    }

    void displayAdmin() {
        displayPerson();
        System.out.println("Department: " + department);
        System.out.println("Role: " + role);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("=== Single Inheritance (Student) ===");
            Student s = new Student();
            s.inputStudent(sc);

            System.out.println("\n=== Multilevel Inheritance (Graduate Student) ===");
            GraduateStudent g = new GraduateStudent();
            g.inputGradStudent(sc);

            System.out.println("\n=== Hierarchical Inheritance (Teacher) ===");
            Teacher t = new Teacher();
            t.inputTeacher(sc);

            System.out.println("\n=== Hierarchical Inheritance (Administrator) ===");
            Administrator a = new Administrator();
            a.inputAdmin(sc);

            System.out.println("\n-----------------------------------------");
            System.out.println("DETAILS DISPLAY");
            System.out.println("-----------------------------------------");

            System.out.println("\n--- Student Details ---");
            s.displayStudent();

            System.out.println("\n--- Graduate Student Details ---");
            g.displayGradStudent();

            System.out.println("\n--- Teacher Details ---");
            t.displayTeacher();

            System.out.println("\n--- Administrator Details ---");
            a.displayAdmin();

        } catch (Exception e) {
            System.out.println("Error processing input: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

/*
 * HOW TO RUN:
 * 1. Open terminal in this folder.
 * 2. javac InheritanceDemo.java
 * 3. java InheritanceDemo
 * 4. Enter details for Student, GraduateStudent, Teacher, Administrator.
 * Direct run (Java 11+): java InheritanceDemo.java
 */
