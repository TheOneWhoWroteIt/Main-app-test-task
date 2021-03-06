package com.godeltech.Mainapptesttask.service;

import com.godeltech.Mainapptesttask.dao.EmployeeDAOImpl;
import com.godeltech.Mainapptesttask.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {


    EmployeeDAOImpl employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAOImpl employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> findAllEmployee(){

        return employeeDAO.findAllEmployee();
    }

    public Employee findEmployeeById(Long id){
        return employeeDAO.findEmployeeById(id);
    }

    public Employee addEmployee(Employee employee){
        employeeDAO.addEmployee(employee);

        return employee;
    }

    public Employee updateEmployee(Employee employee, Long id){
        return employeeDAO.updateEmployee(employee, id);
    }

    public int deleteEmployee(Long id){
        return employeeDAO.deleteEmployee(id);
    }
}
