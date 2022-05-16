package com.example.employeeproject.controller;

import com.example.employeeproject.module.Employee;
import com.example.employeeproject.services.IEmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeInterface iEmployeeInterface;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        Employee newEmployee = iEmployeeInterface.addEmployee(employee);
        return newEmployee;
    }

    @GetMapping("/search/{id}")
    public Optional<Employee> searchById(@PathVariable int id){
        Optional<Employee> response = iEmployeeInterface.searchById(id);
        return response;
    }

    @GetMapping("/show")
    public List<Employee> searchAll(){
        List<Employee> response = iEmployeeInterface.searchAll();
        return response;
    }

    @PutMapping("/edit/{id}")
    public Employee editById(@PathVariable int id,@RequestBody Employee employee){
        Employee response = iEmployeeInterface.editById(id,employee);
        return response;
    }

    @DeleteMapping("/remove/{id}")
    public String removeById(@PathVariable int id) {
        return iEmployeeInterface.removeById(id);
    }
}
