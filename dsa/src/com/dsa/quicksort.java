package com.dsa;

public class quicksort {

	public static void quickSort(int[] arr, int l, int h) {
		
	}
	
	public static int splitArray(int[] arr, int l, int h) {
		int pivot = arr[h];
		int i = l-1;
		for(int j = l;j<h;j++) {
			if(arr[j] <= pivot) {
				i++;
				swapElements(arr, i, j);
			}
		}
		swapElements(arr, i+1, h);
		
		return i+1;
		
	}
	
	
	private static void swapElements(int[] arr, int i, int h) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
