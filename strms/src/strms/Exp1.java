//MAP

package strms;

import java.util.Arrays;
import java.util.List;

public class Exp1 {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("sky", "virat", "rohit", "dhoni", "sourav");
		
		names.stream().map(String::toUpperCase).forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(2,5,7,9);
		numbers.stream().map(x -> x*x).forEach(System.out::println);

	}

}
