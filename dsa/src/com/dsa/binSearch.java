package com.dsa;

import java.util.Arrays;

public class binSearch {

	public static int binarySearch(int[] arr, int target) {
		int h = arr.length -1;
		int l = 0;
		
		while(l <= h) {
			int m = l+(h-l)/2;
			if(arr[m] == target) {
				return m;
			}
			else if(arr[m]<target) {
				l = m+1;
			}
			else {
				h = m-1;
			}
		}
		return -1;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 22, 32, 56, 76, 88, 90};
		int idx = binarySearch(arr, 56);
		System.out.println("elem index: "+ idx);

	}

}
