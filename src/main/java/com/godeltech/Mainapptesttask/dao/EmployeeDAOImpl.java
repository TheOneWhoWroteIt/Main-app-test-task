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


    JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        jdbcTemplate.update("update employee set first_name=?, last_name=?, department_id=?, job_title=?, gender=?::gender, date_of_birth=? where employee_id =?",
                new Object[]{employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth(), id});

        return findEmployeeById(id);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return jdbcTemplate.update("delete from employee where employee_id=?", new Object[]{id}) > 0;
    }
}
