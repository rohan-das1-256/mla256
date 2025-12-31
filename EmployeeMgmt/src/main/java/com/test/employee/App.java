package com.test.employee;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

	private static final Scanner scanner = new Scanner(System.in);
	private static final EmployeeDAO dao = new EmployeeDAOImpl();
	static Connection con;

	public static void main(String[] args) throws Exception {
		
		String driver = "com.mysql.jdbc.Driver";

		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String pass = "root@39";
		
		Class.forName(driver);

		con = DriverManager.getConnection(url, user, pass);
		

		System.out.println("=== Employee Management ===");
		boolean running = true;

		while (running) {
			System.out.println("""
					1. Add Employee
					2. Update Employee
					3. Delete Employee
					4. List Employees
					5. Exit
					Choose option: """);

			String choice = scanner.nextLine().trim();
			try {
				switch (choice) {
				case "1" -> addEmployeeFlow();
				case "2" -> updateEmployeeFlow();
				case "3" -> deleteEmployeeFlow();
				case "4" -> listEmployeesFlow();
				case "5" -> running = false;
				default -> System.out.println("Invalid option. Try again.");
				}
			} catch (Exception e) {
				System.err.println("Operation failed: " + e.getMessage());
			}
		}

		System.out.println("Goodbye!");

	}

	private static void addEmployeeFlow() {
		System.out.print("Name: ");
		String name = scanner.nextLine().trim();

		System.out.print("Email: ");
		String email = scanner.nextLine().trim();

		System.out.print("Department: ");
		String department = scanner.nextLine().trim();

		System.out.print("Salary: ");
		BigDecimal salary = new BigDecimal(scanner.nextLine().trim());

		System.out.print("Joined On (YYYY-MM-DD): ");
		LocalDate joinedOn = LocalDate.parse(scanner.nextLine().trim());

		System.out.print("Active? (true/false): ");
		boolean active = Boolean.parseBoolean(scanner.nextLine().trim());

		Employee emp = new Employee(null, name, email, department, salary, joinedOn, active);
		Employee created = dao.addEmployee(emp, con);
		System.out.println("Created: " + created);
	}

	private static void updateEmployeeFlow() {
		System.out.print("Employee ID to update: ");
		Integer id = Integer.parseInt(scanner.nextLine().trim());

		System.out.print("New Name: ");
		String name = scanner.nextLine().trim();

		System.out.print("New Email: ");
		String email = scanner.nextLine().trim();

		System.out.print("New Department: ");
		String department = scanner.nextLine().trim();

		System.out.print("New Salary: ");
		BigDecimal salary = new BigDecimal(scanner.nextLine().trim());

		System.out.print("New Joined On (YYYY-MM-DD): ");
		LocalDate joinedOn = LocalDate.parse(scanner.nextLine().trim());

		System.out.print("Active? (true/false): ");
		boolean active = Boolean.parseBoolean(scanner.nextLine().trim());

		Employee emp = new Employee(id, name, email, department, salary, joinedOn, active);
		Employee updated = dao.updateEmployee(emp, con);
		System.out.println("Updated: " + updated);
	}

	private static void deleteEmployeeFlow() {
		System.out.print("Employee ID to delete: ");
		int id = Integer.parseInt(scanner.nextLine().trim());
		List<Employee> remaining = dao.deleteEmployee(id, con);
		System.out.println("Deleted. Remaining employees:");
		remaining.forEach(System.out::println);
	}

	private static void listEmployeesFlow() {
		List<Employee> all = dao.getAllEmployees(con);
		if (all.isEmpty()) {
			System.out.println("No employees found.");
		} else {
			all.forEach(System.out::println);
		}
	}

}
