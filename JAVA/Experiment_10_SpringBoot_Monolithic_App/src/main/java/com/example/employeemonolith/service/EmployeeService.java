package com.example.employeemonolith.service;

import com.example.employeemonolith.entity.Employee;
import com.example.employeemonolith.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
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
