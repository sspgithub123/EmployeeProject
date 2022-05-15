package com.example.employeeproject.controller;

import com.example.employeeproject.Module.Employee;
import com.example.employeeproject.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Shubham";
    }
    /*--------------------Post Operation-------------------*/
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeServices.addEmployee(employee);
        return newEmployee;
    }
    /*--------------------Search by Id---------------------*/
    @GetMapping("/search/{id}")
    public Optional<Employee> searchById(@PathVariable int id){
        Optional<Employee> response = employeeServices.searchById(id);
        return response;
    }

    /*----------------------Show all records ------------------*/
    @GetMapping("/show")
    public List<Employee> searchAll(){
        List<Employee> response = employeeServices.searchAll();
        return response;
    }

    /*-----------------------Edit by ID----------------------*/
    @PutMapping("/edit/{id}")
    public Employee editById(@PathVariable int id,@RequestBody Employee employee){
        Employee response = employeeServices.editById(id,employee);
        return response;
    }

    /*-----------------------Delete by Id---------------------*/

    @DeleteMapping("/remove/{id}")
    public String removeById(@PathVariable int id) {
        String response = employeeServices.removeById(id);
        return response;
    }
}
