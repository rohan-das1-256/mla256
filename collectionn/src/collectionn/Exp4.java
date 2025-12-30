//TreeMap

package collectionn;

import java.util.TreeMap;

public class Exp4 {

	public static void main(String[] args) {

		TreeMap<String, Integer> data =new TreeMap<>();
		data.put("java", 21);
		data.put("Python", 14);
		data.put("android", 16);
		data.put("zen", 33);
		data.put("ios", 26);
		data.put("roh", null);
		
		data.forEach((k,v) -> System.out.println("Item: "+k+" | version: "+v));
	}

}
