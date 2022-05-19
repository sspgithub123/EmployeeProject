package com.example.employeeproject.services;

import com.example.employeeproject.dto.EmployeeDTO;
import com.example.employeeproject.module.Employee;

import java.util.List;


public interface IEmployeeInterface{

    String removeById(int id);

    String editById(int id, EmployeeDTO employee);

    List<Employee> searchAll();

    Employee searchById(int id);

    Employee addEmployee(Employee employee);
}