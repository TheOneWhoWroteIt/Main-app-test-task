package com.godeltech.Mainapptesttask.dao;

import com.godeltech.Mainapptesttask.entity.Employee;
import com.godeltech.Mainapptesttask.entity.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Employee> findAllEmployee() {
        return jdbcTemplate.query("select * from employee", new EmployeeMapper());
    }
}
