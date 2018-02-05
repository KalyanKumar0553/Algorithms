package com.src.geeksforgeeks.dynamicprogramming;


import java.util.Scanner;


public class Program004 {
	public static void main(String[] args) {
		Scanner scr=new Scanner(System.in);
		String one=scr.next();
		String two=scr.next();
		System.out.println(getLRSDP(one.toCharArray(),one.toCharArray()));
	}
	public static int getLRSRecursive(char one[],char two[],int i,int j) {
		if(i<0 || j<0) {
			return 0;
		} if (one[i] == two[j] && i!=j) {
			return 1+getLRSRecursive(one,two,i-1,j-1);
		} else {
			return Math.max(getLRSRecursive(one,two,i-1,j),getLRSRecursive(one,two,i,j-1));
		}
	}
	public static int getLRSDP(char one[],char two[]) {
		int LRS[][]=new int [one.length+1][two.length+1];
		for(int i=0;i<=one.length;i++) {
			for(int j=0;j<=two.length;j++) {
				if(i==0 || j==0) {
					LRS[i][j] = 0;
				}else if(one[i-1] == two[j-1] && i!=j) {
					LRS[i][j] = 1 + LRS[i-1][j-1];
				} else {
					LRS[i][j] =Math.max(LRS[i][j-1],LRS[i-1][j]);
				}
			}
		}
		return LRS[one.length][two.length];
	}
}