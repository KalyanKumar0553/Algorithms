package com.src.geeksforgeeks.dynamicprogramming;


import java.util.Scanner;



public class Program001 {
	public static void main(String[] args) {
		Scanner scr=new Scanner(System.in);
		int n=scr.nextInt();
		System.out.println(getNumber(n));
	}
	public static int getNumber(int n){
		int data[]=new int[n];
		if(n==0){
			return 0;
		} else if(n<=2) {
			return 1;
		} else {
			data[0] = 1;
			data[1] = 1;
			int i;
			for(i=2;i<data.length;i++){
				data[i]=data[i-1]+data[i-2];
			}
			return data[i-1];
		}
	}
	public static void display(int number[]){
		for(int i=0;i<number.length;i++){
			System.out.print(number[i]+",");
		}
		System.out.println();
	}
}
