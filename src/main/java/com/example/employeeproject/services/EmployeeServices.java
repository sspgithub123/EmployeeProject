package com.example.employeeproject.services;

import com.example.employeeproject.dto.EmployeeDTO;
import com.example.employeeproject.exceptionHandling.EmployeeException;
import com.example.employeeproject.module.Employee;
import com.example.employeeproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices implements IEmployeeInterface{

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        Employee newEmployee = new Employee(employee);
        employeeRepository.save(newEmployee);
        return newEmployee;
    }

    public Employee searchById(int id) {
        if (employeeRepository.findById(id).isPresent()){
            Employee newEmployee = new Employee(id);
            return newEmployee;
        }
        else throw (new EmployeeException("record not Found"));
    }

    public List<Employee> searchAll() {
        return employeeRepository.findAll();
    }

    public String editById(int id, EmployeeDTO employeeDTO) {
        if (employeeRepository.findById(id).isPresent()) {
            Employee newEmployee = new Employee(id, employeeDTO);
            Employee search = employeeRepository.save(newEmployee);
            return "Done " + search;
        }
        else throw (new EmployeeException("Wrong input"));
    }

    public String removeById(int id) {
        Optional<Employee> newEmployee = employeeRepository.findById(id);
        if (newEmployee.isPresent()){
            employeeRepository.delete(newEmployee.get());
            return "Record is deleted with id " +id;
        }
        else throw (new EmployeeException("Record not Found"));
    }
}