package com.example.employeemonolith.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private double salary;

    public Employee() {}

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}

/*
 * HOW TO RUN:
 * Needs Java 17+ and Maven. In the Experiment_10 folder run:
 * 1. mvn spring-boot:run
 * 2. Open http://localhost:8080/api/employees
 * 3. Add:  curl -X POST localhost:8080/api/employees -H "Content-Type: application/json" -d '{"name":"Amit","department":"IT","salary":50000}'
 * 4. H2 console: http://localhost:8080/h2-console  (URL jdbc:h2:mem:employeedb, user sa)
 * Direct run: mvn package, then java -jar target/employee-monolith-0.0.1-SNAPSHOT.jar
 * (In IDE: run EmployeeMonolithApplication.java)
 */
