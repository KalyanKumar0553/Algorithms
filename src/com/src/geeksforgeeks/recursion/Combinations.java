package com.src.geeksforgeeks.recursion;

import java.util.HashMap;

public class Combinations {
	public static HashMap<Integer, String> data = new HashMap();
	static {
		data.put(2, "abc");
		data.put(3, "def");
		data.put(4, "ghi");
		data.put(5, "jkl");
		data.put(6, "mno");
		data.put(7, "pqrs");
		data.put(8, "tuv");
		data.put(9, "wxyz");
	}

	public static void main(String[] args) {
		printCombinations("22");
	}

	private static void printCombinations(String input) {
		printCombinations(input.length(), input.toCharArray(), "", 0);
	}

	private static void printCombinations(int length, char[] input, String result, int index) {
		if (result.length() >= length || index >= length) {
			if (result.length() == length) {
				System.out.println(result);
			}
			return;
		} else {
			for (int i = 0; i < data.get(Character.getNumericValue(input[index])).length(); i++) {
				printCombinations(length, input, result + data.get(Character.getNumericValue(input[index])).charAt(i),
						index + 1);
			}
		}
	}
}
