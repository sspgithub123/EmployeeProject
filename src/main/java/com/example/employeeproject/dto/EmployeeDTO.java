package com.example.employeeproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public @ToString class EmployeeDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zAZ\\s]{2,}$", message = "Employee name Invalid")
    public String fullName;
    @NotNull(message = "Profile pic can not be null...")
    public String profilePic;
    @NotBlank(message = "Please enter gender..")
    public String gender;

    @NotEmpty(message = "Please Enter the department at least 1")
    @ElementCollection
    @CollectionTable(name = "department",joinColumns = @JoinColumn(name = "id"))
    public List<String> department;
    @Min(value = 10000, message = "Enter the salary more than 10000")
    public int salary;
    @NotNull(message = "Mobile number can not be Null")
    public String mobileNumber;

    @NotNull(message = "Date Should not be null...")
    @JsonFormat(pattern="dd MM yyyy")
    @PastOrPresent(message = "Enter valid date...")
    public LocalDate startDate;
    @NotEmpty(message = "Notes can not be Empty")
    public String notes;
}