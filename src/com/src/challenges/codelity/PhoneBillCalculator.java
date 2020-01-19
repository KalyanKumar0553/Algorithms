package com.src.challenges.codelity;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBillCalculator {
	private static String input = "00:01:07,400-234-090\r\n" + 
			"   00:05:01,701-080-080\r\n" + 
			"   00:05:00,400-234-090\r\n";
	public static void main(String[] args) {
		String data[] = input.split("\n");
		LinkedHashMap<String,String> billDetails = new LinkedHashMap(); 
		Arrays.stream(data).forEach(itm -> {
			String partitions[]=itm.split(",");
			String duration = billDetails.get(partitions[1]);
			if(duration == null) {
				billDetails.put(partitions[1],partitions[0]);
			} else {
				billDetails.put(partitions[1],duration+partitions[0]);				
			}
		});
		System.out.println(billDetails);
	}
}
