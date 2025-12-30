package collectionn;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private int salary;
	
	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, salary);
//		return 7;
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
		return id == other.id && Objects.equals(name, other.name) && salary == other.salary;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.id -o.id;
	}
		
}


class NameSorting implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}


public class Exp7 {
	public static void main(String[] args) {
//		HashSet<Employee> data = new HashSet<>();						//UNSORTED
		TreeSet<Employee> data = new TreeSet<>(new NameSorting()); 		//SORTED IN ASCENDING ORDER
		data.add(new Employee(101, "rohit", 345));
		data.add(new Employee(201, "kohli", 402));
		data.add(new Employee(301, "rahul", 302));
		data.add(new Employee(401, "dravid", 202));
		data.add(new Employee(501, "sourav", 102));
		data.add(new Employee(201, "kohli", 402));
		
		
//		data.forEach(System.out::println);
		
		//	CONSUMER
		Consumer<Employee> csmr = System.out::println;
		data.forEach(csmr);
		
		
		//	PREDICATE
		Predicate<Employee> prdct = x-> x.getSalary() > 300;
		System.out.println(data.stream().filter(prdct).toList());
	}
}
