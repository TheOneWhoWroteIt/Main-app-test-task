package com.godeltech.Mainapptesttask.dao;

import com.godeltech.Mainapptesttask.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAllEmployee();
    Employee findEmployeeById(Long id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    boolean deleteEmployee(Long id);
}
