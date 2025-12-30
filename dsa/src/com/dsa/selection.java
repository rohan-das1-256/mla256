package com.dsa;

import java.util.Arrays;

public class selection {

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for(int i = 0; i<n-1; i++) {
			int minIdx = i;
			for(int j = i+1; j < n; j++) {
				if(arr[j]<arr[minIdx]) {
					minIdx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {22,76,45,-7,7,32,78,76};
		System.out.println("array before sorting: "+ Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("array before sorting: "+ Arrays.toString(arr));
		
	}

}
