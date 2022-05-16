package com.example.employeeproject.services;

import com.example.employeeproject.module.Employee;
import java.util.List;
import java.util.Optional;

public interface IEmployeeInterface{

    String removeById(int id);

    Employee editById(int id, Employee employee);

    List<Employee> searchAll();

    Optional<Employee> searchById(int id);

    Employee addEmployee(Employee employee);
}
