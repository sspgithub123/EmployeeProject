package com.example.employeeproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zAZ\\s]{2,}$", message = "Employee name Invalid")
    public String fullName;
    public String profilePic;
    @NotBlank(message = "Please enter gender..")
    public String gender;
    public String department;
    @Min(value = 10000, message = "Enter the salary more than 10000")
    public int salary;
    @NotNull(message = "Please Enter the mobile number.....")
    public int mobileNumber;
    @PastOrPresent(message = "Enter valid date...")
    public LocalDate startDate;
    public String notes;
}