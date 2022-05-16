package com.example.employeeproject.module;

import com.example.employeeproject.dto.EmployeeDTO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    int id;
    String fullName;
    String profilePic;
    String gender;
    String department;
    int salary;
    int mobileNumber;
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

    public Employee(int id, EmployeeDTO employee) {
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


    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee(int id, String fullName, String profilePic, String gender, String department, int salary, LocalDate startDate,int mobileNumber,String notes) {
        this.id = id;
        this.fullName = fullName;
        this.profilePic = profilePic;
        this.gender = gender;
        this.department = department;
        this.mobileNumber = mobileNumber;
        this.notes = notes;
        this.salary = salary;
        this.startDate = startDate;
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

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", mobileNumber=" + mobileNumber +
                ", startDate=" + startDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}