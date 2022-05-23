package com.example.employeeproject.repository;


import com.example.employeeproject.module.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT * FROM employee e, department ed WHERE e.id = ed.id AND ed.department = :dept", nativeQuery = true)
    List<Employee> findEmployeeByDepartment(@Param("dept") String department);
}