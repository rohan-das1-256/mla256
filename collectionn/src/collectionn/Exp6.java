//package collectionn;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Objects;
//
//class Book implements Comparable<Book>{
//	private int id;
//	private String name;
//	private double price;
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public double getPrice() {
//		return price;
//	}
//	public void setPrice(double price) {
//		this.price = price;
//	}
//	@Override
//	public String toString() {
//		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, name, price);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Book other = (Book) obj;
//		return id == other.id && Objects.equals(name, other.name)
//				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
//	}
//	@Override
//	public int compareTo(Book b) {
//		// TODO Auto-generated method stub
//		return this.id - b.id;
//	}
//	public Book(int id, String name, double price) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//	}
//	
//}
//
//
//class nameComparatorClass implements Comparator<Book>{
//
//	@Override
//	public int compare(Book o1, Book o2) {
//		// TODO Auto-generated method stub
//		return o1.getName().compareTo(o2.getName());
//	}
//	
//}
//
//
//public class Exp6 {
//
//	public static void main(String[] args) {
//		List<Book> data =  new ArrayList<>();
//		data.add(new Book(101, "java", 340.55));
//		data.add(new Book(201, "python", 280.65));
//		data.add(new Book(501, "kotlin", 564.56));		
//		data.add(new Book(301, "js", 364.56));		
//		System.out.println(data);
//		
//		Collections.sort(data);
//		System.out.println(data);
//		
//		Collections.shuffle(data);
//		System.out.println(data);
//		
//		System.out.println("using comparator");
//		Collections.sort(data, new nameComparatorClass());
//		data.forEach(System.out::println);
//	}
//}
