package com.src.geeksforgeeks.dynamicprogramming;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Date;

public class Program006 {

	java.sql.Date d;
	public static void main(String[] args) {
		int a[]= {3,2,1,4};
		int segments = 4;
		int x =5;
		isMinimum(a,segments,x);
	}

	private static void isMinimum(int[] a, int segments, int x) {
		int max_current_segment=Integer.MIN_VALUE;
		int min_max_so_far=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++) {
			if(i% (a.length/segments)==0) {
				max_current_segment = a[i];
			}else if(a[i]>max_current_segment) {
				max_current_segment = a[i];
			}
			if((i+1)% (a.length/segments)==0) {
				if(max_current_segment < min_max_so_far) {
					min_max_so_far = max_current_segment ;
				}
			}
		}
		System.out.println(min_max_so_far);
	}
}