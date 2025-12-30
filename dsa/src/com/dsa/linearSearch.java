package com.dsa;

import java.util.Arrays;

public class linearSearch {

	public static int linearSearch(int[] arr, int target) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == target) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {64, 34, 25, 12, 22, 11, 90};
		int idx = linearSearch(arr, 22);
		System.out.println("elem index: "+ idx);

	}

}
