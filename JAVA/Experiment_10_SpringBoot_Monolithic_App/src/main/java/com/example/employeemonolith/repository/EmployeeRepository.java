package com.example.employeemonolith.repository;

import com.example.employeemonolith.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
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
