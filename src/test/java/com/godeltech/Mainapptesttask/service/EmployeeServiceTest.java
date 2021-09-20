package com.godeltech.Mainapptesttask.service;

import com.godeltech.Mainapptesttask.dao.EmployeeDAO;
import com.godeltech.Mainapptesttask.dao.EmployeeDAOImpl;
import com.godeltech.Mainapptesttask.entity.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@JdbcTest
@Sql(scripts = "/data-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeServiceTest {

    @Autowired
    JdbcTemplate jdbcTemplateTest;

    @Test
    void findAllEmployee() {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl(jdbcTemplateTest);
        List<Employee> employeeList = employeeDAO.findAllEmployee();

        Assert.assertTrue(!employeeList.isEmpty());
        Assert.assertTrue(employeeList.size() == 4);

    }

    @Test
    void findEmployeeById() {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(jdbcTemplateTest);
        Employee employee = employeeDAO.findEmployeeById(1L);

        Assert.assertTrue(employee != null);
        Assert.assertTrue(employee.getFirstName().equals("petr_test"));
        Assert.assertTrue(employee.getLastName().equals("petrov_test"));
    }

    @Test
    void addEmployee() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployee() {
    }
}