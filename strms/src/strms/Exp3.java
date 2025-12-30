package strms;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exp3 {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(3,5,7,9);
		Optional<Integer> dt = nums.stream().findAny();
		
		if(dt.isPresent()) {
			System.out.println( dt.get());
		}
		
		else {
			System.out.println("no data");
		}
		
		
		List<String> names = Arrays.asList("sky", "virat", "rohit", "dhoni", "sourav");
		Optional<String> rslt = names.stream().findFirst();
		if(rslt.isPresent()) {
			System.out.println( rslt.get());
		}
		
		else {
			System.out.println("no data");
		}
		
	}

}
