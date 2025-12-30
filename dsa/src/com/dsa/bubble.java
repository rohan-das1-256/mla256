package com.dsa;

import java.util.Arrays;

public class bubble {

	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for(int i =0; i<n-1; i++) {
			for(int j = 0; j<n-i-1; j++) {
				if( arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {64, 34, 25, 12, 22, 11, 90};
		System.out.println("array before sorting: "+ Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("array before sorting: "+ Arrays.toString(arr));

	}

}
