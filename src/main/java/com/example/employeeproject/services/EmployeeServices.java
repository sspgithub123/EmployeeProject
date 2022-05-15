package com.example.employeeproject.services;

import com.example.employeeproject.Module.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    IEmployeeInterface iEmployeeInterface;

    public Employee addEmployee(Employee employee) {
        Employee newEmployee = new Employee(employee);
        iEmployeeInterface.save(newEmployee);
        return newEmployee;
    }

    public Optional<Employee> searchById(int id) {
        return iEmployeeInterface.findById(id);
    }

    public List<Employee> searchAll() {
        return iEmployeeInterface.findAll();
    }

    public Employee editById(int id, Employee employee) {
        Employee newEmployee = new Employee(id,employee);
        iEmployeeInterface.save(newEmployee);
        return newEmployee;
    }

    public String removeById(int id) {
        Optional<Employee> newEmployee = iEmployeeInterface.findById(id);
        if (newEmployee.isPresent()){
            iEmployeeInterface.delete(newEmployee.get());
            return "Record is deleted with id " +id;
        }
        return "Record not Found";
    }
}