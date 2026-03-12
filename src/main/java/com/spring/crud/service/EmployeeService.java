package com.spring.crud.service;

import com.spring.crud.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employeeDetails);

    void deleteEmployee(Long id);

    List<Employee> getEmployeesByDepartment(String department);

    List<Employee> searchEmployeesByName(String name);
}
