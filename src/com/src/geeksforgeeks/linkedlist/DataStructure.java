package com.src.geeksforgeeks.linkedlist;

import java.util.ArrayList;
import java.util.List;

class A {
	
}
class B extends A {
	
}
class DataStructure {
	public static void main(String[] args) {
		List data=new ArrayList<A>();
		get(data);
	}
	public static <T> void get(List<T> i) {
		i.set(0, i.get(0));
	}
	
}