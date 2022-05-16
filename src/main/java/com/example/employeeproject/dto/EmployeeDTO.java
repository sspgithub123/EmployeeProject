package com.example.employeeproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    public String fullName;
    public String profilePic;
    public String gender;
    public String department;
    public int salary;
    public int mobileNumber;
    public LocalDate startDate;
    public String notes;
}
