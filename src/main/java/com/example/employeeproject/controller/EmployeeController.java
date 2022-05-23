package com.example.employeeproject.controller;

import com.example.employeeproject.dto.EmployeeDTO;
import com.example.employeeproject.dto.ResponseDTO;
import com.example.employeeproject.module.Employee;
import com.example.employeeproject.services.IEmployeeInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
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
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        Employee newEmployee = new Employee(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added record Successfully", iEmployeeInterface.addEmployee(newEmployee));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ResponseDTO> searchById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Record found successfully", iEmployeeInterface.searchById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.CREATED);
    }

    @GetMapping("/show-all")
    public ResponseEntity<ResponseDTO> searchAll(){
        ResponseDTO responseDTO = new ResponseDTO("Getting all the record....", iEmployeeInterface.searchAll());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDTO> editById(@Valid @PathVariable int id,@RequestBody EmployeeDTO employeeDTO){
        ResponseDTO responseDTO = new ResponseDTO("Update success", iEmployeeInterface.editById(id,employeeDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseDTO> removeById(@PathVariable int id) {
        Employee employee = new Employee(id);
        ResponseDTO responseDTO = new ResponseDTO("Record found and removed successful", iEmployeeInterface.removeById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/dept/{department}")
    public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable("department") String department){
        List<Employee> employeeList = iEmployeeInterface.getEmployeeByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID successful", employeeList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}