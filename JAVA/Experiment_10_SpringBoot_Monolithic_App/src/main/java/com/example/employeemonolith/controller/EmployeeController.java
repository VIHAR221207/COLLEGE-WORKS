package com.example.employeemonolith.controller;

import com.example.employeemonolith.entity.Employee;
import com.example.employeemonolith.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
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
