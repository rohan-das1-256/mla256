package collectionn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Exp3 {

	public static void main(String[] args) {

		Map data = new HashMap<>();
		data.put("java", "spring");
		data.put("python", "fastAPI");
		data.put(13, "Android");
		
		
		System.out.println(data);
		
		Iterator<Map.Entry> itr = data.entrySet().iterator();
		while(itr.hasNext()) {
			Entry et = itr.next();
			System.out.println(et.getKey()+" : "+et.getValue());
		}
		
		data.keySet().forEach(x-> System.out.println(x+" :: "+ data.get(x)));
	}

}
