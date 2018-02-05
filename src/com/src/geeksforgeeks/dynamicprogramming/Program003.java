package com.src.geeksforgeeks.dynamicprogramming;


import java.util.Scanner;


public class Program003 {
	public static void main(String[] args) {
		Scanner scr=new Scanner(System.in);
		String one=scr.next();
		String two=scr.next();
		System.out.println(getLCSDP(one.toCharArray(),two.toCharArray()));
	}
	public static int getLCSRecursive(char one[],char two[],int i,int j) {
		if(i<0 || j<0) {
			return 0;
		} if (one[i] == two[j]) {
			return 1+getLCSRecursive(one,two,i-1,j-1);
		} else {
			return Math.max(getLCSRecursive(one,two,i-1,j),getLCSRecursive(one,two,i,j-1));
		}
	}
	public static int getLCSDP(char one[],char two[]) {
		int LCS[][]=new int [one.length+1][two.length+1];
		for(int i=0;i<=one.length;i++) {
			for(int j=0;j<=two.length;j++) {
				if(i==0 || j==0) {
					LCS[i][j] = 0;
				}else if(one[i-1] == two[j-1]) {
					LCS[i][j] = 1 + LCS[i-1][j-1];
				} else {
					LCS[i][j] =Math.max(LCS[i][j-1],LCS[i-1][j]);
				}
			}
		}
		return LCS[one.length][two.length];
	}
}