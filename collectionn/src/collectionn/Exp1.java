package collectionn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class Exp1 {

	public static void main(String[] args) {
//		ArrayList data = new ArrayList<>();
//		CopyOnWriteArrayList data = new CopyOnWriteArrayList<>();
		Stack data = new Stack<>();
		
		data.add("Rohan");
		data.add('D');
		data.add(79);
		data.add(3.14f);
//		System.out.println(data);  //stored in insertion order
		
		
		//Iterator, ListIterator, Enumeration
		Iterator itr = data.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
//		ListIterator itr1 = data.listIterator(data.size());
//		while(itr1.hasPrevious()) {
//			System.out.println(itr1.previous());
//		}
//		
//		data.add(false);
//		System.out.println(data.size());
//		System.out.println(data);
//		
//		data.set(4, true);
//		System.out.println(data);
		
		
		// CONCURRENT OPERATION
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//			
//			data.add("virat");
//		}
		
//		System.out.println(data.peek());
//		data.push("lazy");
//		System.out.println(data.peek());
//		data.pop();
//		System.out.println(data.peek());
//		System.out.println(data.empty());
		
//		System.out.println(data.search(79));
		
		
		data.clear();
		System.out.println(data);
		
		
		

	}

}
