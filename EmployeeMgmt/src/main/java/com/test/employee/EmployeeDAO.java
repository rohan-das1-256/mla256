package com.test.employee;

import java.sql.Connection;
import java.util.List;

public interface EmployeeDAO {

	Employee addEmployee(Employee emp, Connection con);
	Employee updateEmployee(Employee emp, Connection con);
	List<Employee> deleteEmployee(int id, Connection con);
	List<Employee> getAllEmployees(Connection con);
}
