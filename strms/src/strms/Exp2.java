package strms;

import java.util.Arrays;
import java.util.List;

public class Exp2 {
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
		List<Integer> list2 = Arrays.asList(7,8,9,10);
		
		List<List<Integer>> cmbnd = Arrays.asList(list1, list2);
		System.out.println(cmbnd);
		
		List<Integer>flattend = cmbnd.stream().flatMap(List::stream).toList();
		System.out.println(flattend);
	}
}
