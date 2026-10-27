/*
 * Experiment 2: Programs on Method and Constructor Overloading
 * Calculator Application demonstrating Compile-Time Polymorphism
 */

public class Calculator {

    // Default Constructor
    public Calculator() {
        System.out.println("Welcome to the Calculator Program!");
    }

    // Parameterized Constructor
    public Calculator(int num1, int num2) {
        int sum = num1 + num2;
        System.out.println("Sum of " + num1 + " and " + num2 + " is: " + sum);
    }

    // Overloaded Method 1: No parameters (adds default numbers 5 and 10)
    public void add() {
        int a = 5;
        int b = 10;
        int sum = a + b;
        System.out.println("Sum of default numbers " + a + " and " + b + " is: " + sum);
    }

    // Overloaded Method 2: Two integer parameters
    public void add(int a, int b) {
        int sum = a + b;
        System.out.println("Sum of " + a + " and " + b + " is: " + sum);
    }

    // Overloaded Method 3: Three float parameters
    public void add(float a, float b, float c) {
        float sum = a + b + c;
        System.out.println("Sum of " + a + ", " + b + " and " + c + " is: " + sum);
    }

    public static void main(String[] args) {
        // Testing Parameterized Constructor
        Calculator calc1 = new Calculator(15, 25);
        System.out.println();

        // Testing Default Constructor and Overloaded Methods
        Calculator calc2 = new Calculator();
        calc2.add();
        calc2.add(20, 30);
        calc2.add(12.5f, 15.5f, 10.0f);
    }
}

/*
 * HOW TO RUN:
 * 1. Open terminal in this folder.
 * 2. javac Calculator.java
 * 3. java Calculator
 * Direct run (Java 11+): java Calculator.java
 */
