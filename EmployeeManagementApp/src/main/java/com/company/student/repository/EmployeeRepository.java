package com.company.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.company.student.entity.Employee;

public interface EmployeeRepository
        extends JpaRepository<Employee,Integer> {

}
