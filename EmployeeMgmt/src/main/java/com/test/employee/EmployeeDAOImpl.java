package com.test.employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

	
	private final List<Employee> cache = new ArrayList<>();
	

	
	
	public EmployeeDAOImpl() {
		
	}
	
	@Override
	public Employee addEmployee(Employee emp, Connection con) {

		String sql = "INSERT INTO employees (name, email, department, salary, joined_on, is_active) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			

			ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getDepartment());
            ps.setBigDecimal(4, emp.getSalary());
            ps.setDate(5, Date.valueOf(emp.getJoinedOn()));
            ps.setBoolean(6, emp.isActive());

            int rows = ps.executeUpdate();
            if (rows == 0) throw new SQLException("Insert failed, no rows affected.");

			try (ResultSet rs = ps.getGeneratedKeys()) {
			                if (rs.next()) {
			                    emp.setId(rs.getInt(1));
			                }
            }


			cache.add(emp);
         


		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;

	}

	@Override
	public Employee updateEmployee(Employee emp, Connection con) {

		if (emp.getId() == null) {
            throw new IllegalArgumentException("Employee id must not be null for update");
        }
        String sql = "UPDATE employees SET name=?, email=?, department=?, salary=?, joined_on=?, is_active=? WHERE id=?";

        try(PreparedStatement ps = con.prepareStatement(sql)) {
        	
        	ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getDepartment());
            ps.setBigDecimal(4, emp.getSalary());
            ps.setDate(5, Date.valueOf(emp.getJoinedOn()));
            ps.setBoolean(6, emp.isActive());
            ps.setInt(7, emp.getId());

            int rows = ps.executeUpdate();
            if (rows == 0) throw new RuntimeException("No employee found with id: " + emp.getId());

            // Update cache
            cache.removeIf(e -> e.getId() != null && e.getId().equals(emp.getId()));
            cache.add(emp);
		} catch (Exception e) {
			throw new RuntimeException("Error updating employee", e);
		}
        return emp;  
	}

	@Override
	public List<Employee> deleteEmployee(int id, Connection con) {
		String sql = "DELETE FROM employees WHERE id=?";
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			

			ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new RuntimeException("No employee found to delete with id: " + id);
            }
            cache.removeIf(e -> e.getId() != null && e.getId() == id);


			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error deleting employee", e);
		}
		return getAllEmployees(con);
		
		
	}

	@Override
	public List<Employee> getAllEmployees(Connection con) {

		String sql = "SELECT id, name, email, department, salary, joined_on, is_active FROM employees ORDER BY id";
        List<Employee> list = new ArrayList<>();
        
        try(PreparedStatement ps = con.prepareStatement(sql);
        		ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getBigDecimal("salary"),
                        rs.getDate("joined_on").toLocalDate(),
                        rs.getBoolean("is_active")
                );
                list.add(e);
            }
            // Refresh cache to mirror DB
            cache.clear();
            cache.addAll(list);
            return list;

		} catch (Exception e) {
			throw new RuntimeException("Error fetching employees", e);
		}

	}

}
