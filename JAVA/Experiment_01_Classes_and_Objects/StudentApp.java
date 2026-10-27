/*
 * Experiment 1: Programs on Classes and Objects
 * Student Details Management System
 */

import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    float marks;

    // Accept student details from user
    public void inputDetails(Scanner scanner) {
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        rollNumber = scanner.nextInt();
        System.out.print("Enter marks: ");
        marks = scanner.nextFloat();
        scanner.nextLine(); // Consume newline
        System.out.println();
    }

    // Display student details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("---------------------------------");
    }
}

public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student student1 = new Student();
        Student student2 = new Student();

        System.out.println("--- Enter Details for Student 1 ---");
        student1.inputDetails(scanner);

        System.out.println("--- Enter Details for Student 2 ---");
        student2.inputDetails(scanner);

        System.out.println("=== Displaying Student Information ===");
        System.out.println("Student 1 Details:");
        student1.displayDetails();

        System.out.println("Student 2 Details:");
        student2.displayDetails();

        scanner.close();
    }
}

/*
 * HOW TO RUN:
 * 1. Open terminal in this folder.
 * 2. javac StudentApp.java
 * 3. java StudentApp
 * 4. Type name, roll number, marks for 2 students.
 * Direct run (Java 11+): java StudentApp.java
 */
