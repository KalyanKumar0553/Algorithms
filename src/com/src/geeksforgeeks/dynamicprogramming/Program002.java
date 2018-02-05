package com.src.geeksforgeeks.dynamicprogramming;


import java.util.Scanner;


public class Program002 {
	public static void main(String[] args) {
		Scanner scr=new Scanner(System.in);
		int i=scr.nextInt();
		int j=scr.nextInt();
		getNumber(i+1,j);
	}
	public static int getNumber(int i,int j){
		int data[][]=new int[i][i];
		int result= Integer.MIN_VALUE;
		if(i==0){
			return 1;
		} else if(i==1) {
			return 1;
		} else {
			data[2][0] = 1;
			data[2][1] = 2;
			data[2][2] = 1;
			for(int k=3;k<data.length;k++){
				data[k][0]=1;
				for(int l=1;l<k;l++) {
					data[k][l] = data[k-1][l-1] + data[k-1][l];
				}
				data[k][data[k].length-1]=1;
			}
			result = data[i-1][j];
		}
		return result;
	}
}
