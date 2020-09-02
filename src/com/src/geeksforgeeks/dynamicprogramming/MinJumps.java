package com.src.geeksforgeeks.dynamicprogramming;

public class MinJumps {
	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 }; // 0-9
        int n = arr.length; 
        System.out.print("Minimum number of jumps to reach end is " + minJumps(arr, 0, n - 1)); 
    
	}

	static int minJumps(int arr[], int l, int h) {
		if (h == l)
			return 0;
		if (arr[l] == 0)
			return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
			int jumps = minJumps(arr, i, h);
			System.out.println(l + ":"+ h + ":" +(jumps+1));
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
				min = jumps + 1;
		}
		return min;
	}
}
