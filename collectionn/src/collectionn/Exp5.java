//collections methods

package collectionn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exp5 {

	public static void main(String[] args) {
		List<String> data = Arrays.asList("rohit", "kohli", "Dravid", "dhoni", "pant", "axar");
		
		System.out.println(data);
		Collections.sort(data);
		System.out.println(data);
		Collections.shuffle(data);
		System.out.println(data);
		data.forEach(d->System.out.println(d));
	}
}
