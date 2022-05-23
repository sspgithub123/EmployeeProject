package com.example.employeeproject.module;

import com.example.employeeproject.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity

@AllArgsConstructor
@NoArgsConstructor
public @Data class Employee {

    @Id
    @GeneratedValue
    int id;
    String fullName;
    String profilePic;
    String gender;
    @ElementCollection
    @CollectionTable(name = "department",joinColumns = @JoinColumn(name = "id"))
    private List<String> department;
    int salary;
    String mobileNumber;

    LocalDate startDate;
    String notes;

    public Employee(int id, Employee employee) {
        this.id = id;
        this.fullName = employee.fullName;
        this.profilePic = employee.profilePic;
        this.gender = employee.gender;
        this.department = employee.department;
        this.mobileNumber = employee.mobileNumber;
        this.notes = employee.notes;
        this.salary = employee.salary;
        this.startDate = employee.startDate;
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, EmployeeDTO employeeDTO) {
        this.id = id;
        this.fullName = employeeDTO.fullName;
        this.profilePic = employeeDTO.profilePic;
        this.gender = employeeDTO.gender;
        this.department = employeeDTO.department;
        this.mobileNumber = employeeDTO.mobileNumber;
        this.notes = employeeDTO.notes;
        this.salary = employeeDTO.salary;
        this.startDate = employeeDTO.startDate;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.fullName = employee.fullName;
        this.profilePic = employee.profilePic;
        this.gender = employee.gender;
        this.department = employee.department;
        this.mobileNumber = employee.mobileNumber;
        this.notes = employee.notes;
        this.salary = employee.salary;
        this.startDate = employee.startDate;

    }
    public Employee(EmployeeDTO employeeDTO) {
        this.fullName = employeeDTO.fullName;
        this.profilePic = employeeDTO.profilePic;
        this.gender = employeeDTO.gender;
        this.department = employeeDTO.department;
        this.mobileNumber = employeeDTO.mobileNumber;
        this.notes = employeeDTO.notes;
        this.salary = employeeDTO.salary;
        this.startDate = employeeDTO.startDate;
    }
}