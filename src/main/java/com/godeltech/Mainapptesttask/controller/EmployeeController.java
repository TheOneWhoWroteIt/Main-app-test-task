package com.godeltech.Mainapptesttask.controller;

import com.godeltech.Mainapptesttask.entity.Employee;
import com.godeltech.Mainapptesttask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
