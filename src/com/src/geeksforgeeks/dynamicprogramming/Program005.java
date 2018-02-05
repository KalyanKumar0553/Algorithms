package com.src.geeksforgeeks.dynamicprogramming;


import java.util.Scanner;


public class Program005 {
	public static void main(String[] args) {
		Scanner scr=new Scanner(System.in);
		int data[]= {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(getLSRecursive(data));
	}
	public static int getLSRecursive(int data[]) {
		int result=-1;
		for(int i=0;i<data.length;i++) {
			for(int j=i;j<data.length;j++) {
				int sum=0;
				for(int k=i;k<=j;k++) {
					sum += data[k];
				}
				if(sum>result) {
					result = sum;
				}
			}
		}
		return result;
	}
	public static int getLSDP(int data[]) {
		int curr_max=0,max_so_far=0;
		for(int i=0;i<data.length;i++) {
			curr_max += data[i];
			if(curr_max > max_so_far) {
				max_so_far = curr_max;
			}
		}
		return max_so_far;
	}
}