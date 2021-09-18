package com.godeltech.Mainapptesttask.controller;

import com.godeltech.Mainapptesttask.entity.Employee;
import com.godeltech.Mainapptesttask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/list")
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

    @PutMapping("/employee/update/{id}")
    public Employee updateEmployee(Employee employee, @PathVariable Long id){

        return employeeService.updateEmployee(employee, id);

    }

    @DeleteMapping("/employee/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
