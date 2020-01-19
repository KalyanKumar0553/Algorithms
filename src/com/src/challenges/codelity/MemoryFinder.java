package com.src.challenges.codelity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryFinder {
	public static void main(String[] args) {
		String input = "my.song.mp3 11b\r\n" + 
				"greatSong.flac 1000b\r\n" + 
				"not3.txt 5b\r\n" + 
				"video.mp4 200b\r\n" + 
				"game.exe 100b\r\n" + 
				"mov!e.mkv 10000b";
		LinkedHashMap result = new LinkedHashMap<String,String>();
		result.put("music", "0");
		result.put("images", "0");
		result.put("movies", "0");
		result.put("other", "0");
		
		for(String currFile : input.split("\n")) {
			String fileName = currFile.split("\\s+")[0];
			Long memory = Long.parseLong(currFile.split("\\s+")[1].replace("b",""));
			String extension = fileName.substring(fileName.lastIndexOf(".")+1); 
			if("mp3aacflac".indexOf(extension)>-1) {
				Long value = Long.parseLong((String)result.get("music")) + memory;
				result.put("music",value.toString());
			} else if("jpgbmpgif".indexOf(extension)>-1) {
				Long value = Long.parseLong((String)result.get("images")) + memory;
				result.put("images",value.toString());
			} else if("mp4avimkv".indexOf(extension)>-1) {
				Long value = Long.parseLong((String)result.get("movies")) + memory;
				result.put("movies",value.toString());
			} else {
				Long value = Long.parseLong((String)result.get("other")) + memory;
				result.put("other",value.toString());
			}
		}
		
		result.put("music", result.get("music")+"b");
		result.put("images",result.get("images")+"b");
		result.put("movies", result.get("movies")+"b");
		result.put("other", result.get("other")+"b");
		
		StringBuffer response = new StringBuffer();
		result.keySet().forEach(key->{
			response.append((key+" "+result.get(key)+"\n"));
		});
		
		System.out.println(response.toString());
	}
}
