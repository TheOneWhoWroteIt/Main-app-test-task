package com.godeltech.Mainapptesttask.controller;

import com.godeltech.Mainapptesttask.entity.Employee;
import com.godeltech.Mainapptesttask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> findAllEmployee(){
        return employeeService.findAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployeeById(@PathVariable Long id) throws Exception {

        Employee employee = employeeService.findEmployeeById(id);
        if(employee == null){
            throw new Exception("Employee with number id: " + id + "  - not found.");
        }
        return employee;
    }

    @PostMapping("/employee/add")
    public Employee addEmployee(Employee employee){
        return employeeService.addEmployee(employee);
    }
}
