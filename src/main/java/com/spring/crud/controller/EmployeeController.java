package com.spring.crud.controller;

import com.spring.crud.model.Employee;
import com.spring.crud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // ✅ CREATE - POST /api/employees
    @PostMapping
    public ResponseEntity<Map<String, Object>> createEmployee(@Valid @RequestBody Employee employee) {
        Employee created = employeeService.createEmployee(employee);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employee created successfully");
        response.put("data", created);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // ✅ READ ALL - GET /api/employees
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employees retrieved successfully");
        response.put("count", employees.size());
        response.put("data", employees);
        return ResponseEntity.ok(response);
    }

    // ✅ READ BY ID - GET /api/employees/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employee retrieved successfully");
        response.put("data", employee);
        return ResponseEntity.ok(response);
    }

    // ✅ UPDATE - PUT /api/employees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employeeDetails) {
        Employee updated = employeeService.updateEmployee(id, employeeDetails);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employee updated successfully");
        response.put("data", updated);
        return ResponseEntity.ok(response);
    }

    // ✅ DELETE - DELETE /api/employees/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employee deleted successfully");
        response.put("id", id);
        return ResponseEntity.ok(response);
    }

    // ✅ SEARCH BY DEPARTMENT - GET /api/employees/department/{dept}
    @GetMapping("/department/{department}")
    public ResponseEntity<Map<String, Object>> getEmployeesByDepartment(@PathVariable String department) {
        List<Employee> employees = employeeService.getEmployeesByDepartment(department);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employees in department: " + department);
        response.put("count", employees.size());
        response.put("data", employees);
        return ResponseEntity.ok(response);
    }

    // ✅ SEARCH BY NAME - GET /api/employees/search?name=John
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchByName(@RequestParam String name) {
        List<Employee> employees = employeeService.searchEmployeesByName(name);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Search results for: " + name);
        response.put("count", employees.size());
        response.put("data", employees);
        return ResponseEntity.ok(response);
    }
}
