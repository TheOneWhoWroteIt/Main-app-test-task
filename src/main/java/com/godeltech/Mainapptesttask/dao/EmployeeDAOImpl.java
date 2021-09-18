package com.godeltech.Mainapptesttask.dao;

import com.godeltech.Mainapptesttask.entity.Employee;
import com.godeltech.Mainapptesttask.entity.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Employee> findAllEmployee() {
        return jdbcTemplate.query("select * from employee", new EmployeeMapper());
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Employee employee = null;

        try{
            employee = jdbcTemplate.queryForObject("select * from employee where employee_id =?", new Object[]{id}, new EmployeeMapper());
        }catch (Exception ex){
            System.out.println("Exception: " + ex);

        }
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {

        jdbcTemplate.update("insert into employee (first_name, last_name, job_title, gender, date_of_birth) values (?,?,?,?::gender,?)",
                new Object[]{employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth()});

        return findEmployeeById(employee.getEmployeeId());
    }
}
