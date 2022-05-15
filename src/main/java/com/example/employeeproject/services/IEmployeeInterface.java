package com.example.employeeproject.services;

import com.example.employeeproject.Module.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeInterface extends JpaRepository<Employee,Integer> {
}
