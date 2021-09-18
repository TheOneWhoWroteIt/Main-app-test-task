package com.godeltech.Mainapptesttask.service;

import com.godeltech.Mainapptesttask.dao.EmployeeDAOImpl;
import com.godeltech.Mainapptesttask.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    EmployeeDAOImpl employeeDAO;

    public List<Employee> findAllEmployee(){

        return employeeDAO.findAllEmployee();
    }
}
