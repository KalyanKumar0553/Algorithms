package com.src.geeksforgeeks.recursion;

//   Fibonnaci Sequence
public class Program001 {
	public static int getFibonnaci(int n) {
		if(n==0 || n==1)
			return n;
		else {
			int x = getFibonnaci(n-1);
			int y=getFibonnaci(n-2);
			return x+y;
		}
	}
	public static void main(String[] args) {
		System.out.println(getFibonnaci(5));
	}
}
