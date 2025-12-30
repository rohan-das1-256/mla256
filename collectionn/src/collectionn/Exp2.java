package collectionn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Exp2 {

	public static void main(String[] args) {
//		HashSet data = new HashSet<>();
//		LinkedHashSet data = new LinkedHashSet<>();
		TreeSet data = new TreeSet();
		
//		data.add("Rohan");
//		data.add('D');
		data.add(79);
		data.add(3);
		data.add(545);
//		data.add(true);
//		data.add("Rohan");
		
		System.out.println(data);
		
		Iterator itr = data.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
