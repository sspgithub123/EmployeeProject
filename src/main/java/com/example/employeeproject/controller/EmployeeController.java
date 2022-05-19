package com.example.employeeproject.controller;

import com.example.employeeproject.dto.EmployeeDTO;
import com.example.employeeproject.dto.ResponseDTO;
import com.example.employeeproject.module.Employee;
import com.example.employeeproject.services.IEmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeInterface iEmployeeInterface;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello, Good Morning";
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        Employee newEmployee = new Employee(employeeDTO);
        iEmployeeInterface.addEmployee(newEmployee);
        ResponseDTO responseDTO = new ResponseDTO("Add record successfully", iEmployeeInterface.addEmployee(newEmployee));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.CREATED);
    }

    @GetMapping("/search-by/{id}")
    public ResponseEntity<ResponseDTO> searchById(@PathVariable int id){

        ResponseDTO responseDTO = new ResponseDTO("Record found successfully", iEmployeeInterface.searchById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.CREATED);
    }

    @GetMapping("/show-all")
    public ResponseEntity<ResponseDTO> searchAll(){
        ResponseDTO responseDTO = new ResponseDTO("Getting all the record.", iEmployeeInterface.searchAll());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/edit-by/{id}")
    public ResponseEntity<ResponseDTO> editById(@PathVariable int id,@Valid @RequestBody EmployeeDTO employeeDTO){
        ResponseDTO responseDTO = new ResponseDTO("Update successfully", iEmployeeInterface.editById(id,employeeDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/remove-by/{id}")
    public ResponseEntity<ResponseDTO> removeById(@PathVariable int id) {
        Employee employee = new Employee(id);
        ResponseDTO responseDTO = new ResponseDTO("Record found and removed successfully", iEmployeeInterface.removeById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}