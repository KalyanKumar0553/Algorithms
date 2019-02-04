package com.src.geeksforgeeks.recursion;

// Binomial Coefficient
public class Program002 {
	public static void main(String[] args) {
		System.out.println(getBinomialCoefficient(4,2));
	}
	private static int getBinomialCoefficient(int n,int k) {
		if(n==0 || n==1) {
			return 1;
		} else {
			if(k==1 || k ==n+1) {
				return 1;
			} else {
				int val1 = getBinomialCoefficient(n-1,k-1);
				int val2 = getBinomialCoefficient(n-1,k);
				return val1 + val2;
			}
		}
	}
}
