package collectionn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

class Book {
	private int id;
	private String name;
	private double price;
	
	public Book(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}


public class Exp8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Book> data = Arrays.asList(
				new Book(101,  "java", 340),
				new Book(201, "php", 10),
				new Book(501, "Python", 43),
				new Book(401, "kotlin", 25),
				new Book(301, "core java", 55));
		
		data.stream().sorted(Comparator.comparing(Book :: getId))
		.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		
		Function<Book, String> fnName = Book::getName;
		Function<Book, Integer> fnid = Book::getId;
		Function<Book, Double> fnPr = Book::getPrice;
		
		data.stream().sorted(Comparator.comparing(fnPr)).forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		data.stream().sorted(Comparator.comparing(fnPr).
										thenComparing(fnid).
										thenComparing(fnName)).forEach(System.out::println);
	}

}
