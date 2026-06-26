package com.company.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.student.entity.Employee;
import com.company.student.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee saveEmployee(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
}