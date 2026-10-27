package com.example.employeemonolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeMonolithApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeMonolithApplication.class, args);
    }
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
