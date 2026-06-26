package com.company.student.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.company.student.entity.Employee;
import com.company.student.service.EmployeeService;

@Controller
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute(
                "employees",
                service.getAllEmployees());

        return "index";
    }

    @GetMapping("/add")
    public String addEmployeeForm(Model model) {

        model.addAttribute(
                "employee",
                new Employee());

        return "addEmployee";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee) {

        service.saveEmployee(employee);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(
            @PathVariable("id") int id) {

        service.deleteEmployee(id);

        return "redirect:/";
    }
    
    
    @GetMapping("/employee/{id}")
    public String getEmployeeById(
            @PathVariable("id") int id,
            Model model) {

        Employee emp =
                service.getEmployeeById(id);

        model.addAttribute(
                "employee",
                emp);

        return "employee-details";
    }
    
    
    @GetMapping("/edit/{id}")
    public String editEmployee(
            @PathVariable("id") int id,
            Model model) {

        Employee emp = service.getEmployeeById(id);

        model.addAttribute("employee", emp);

        return "update-employee";
    }
    
    @PostMapping("/update")
    public String updateEmployee(
            Employee employee) {

        service.saveEmployee(employee);

        return "redirect:/";
    }
  
}