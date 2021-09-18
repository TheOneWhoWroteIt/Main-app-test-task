package com.godeltech.Mainapptesttask.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getLong("employee_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDepartmentId(resultSet.getLong("department_id"));
        employee.setJobTitle(resultSet.getString("job_title"));

        Gender gender = Gender.valueOf(resultSet.getString("gender"));
        LocalDate date = LocalDate.parse(resultSet.getString("date_of_birth"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        employee.setGender(gender);
        employee.setDateOfBirth(date);

        return employee;
    }
}
