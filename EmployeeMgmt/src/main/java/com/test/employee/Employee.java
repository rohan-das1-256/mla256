package com.test.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Employee {


    private Integer id;            // null before insert
    private String name;
    private String email;
    private String department;
    private BigDecimal salary;
    private LocalDate joinedOn;
    private boolean active;
    
    public Employee() {}

	public Employee(Integer id, String name, String email, String department, BigDecimal salary, LocalDate joinedOn,
			boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
		this.joinedOn = joinedOn;
		this.active = active;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getJoinedOn() {
		return joinedOn;
	}

	public void setJoinedOn(LocalDate joinedOn) {
		this.joinedOn = joinedOn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, department, email, id, joinedOn, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return active == other.active && Objects.equals(department, other.department)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(joinedOn, other.joinedOn) && Objects.equals(name, other.name)
				&& Objects.equals(salary, other.salary);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department + ", salary="
				+ salary + ", joinedOn=" + joinedOn + ", active=" + active + "]";
	}
    
    

}
