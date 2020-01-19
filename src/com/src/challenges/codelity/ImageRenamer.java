package com.src.challenges.codelity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImageRenamer {
	private static String input = "photo.jpg, Warsaw, 2013-09-05 14:08:15\r\n" + 
			"john.png, London, 2015-06-20 15:13:22\r\n" + 
			"myFriends.png, Warsaw, 2013-09-05 14:07:13\r\n" + 
			"Eiffel.jpg, Paris, 2015-07-23 08:03:02\r\n" + 
			"pisatower.jpg, Paris, 2015-07-22 23:59:59\r\n" + 
			"BOB.jpg, London, 2015-08-05 00:02:03\r\n" + 
			"notredame.png, Paris, 2015-09-01 12:00:00\r\n" + 
			"me.jpg, Warsaw, 2013-09-06 15:40:22\r\n" + 
			"a.png, Warsaw, 2016-02-13 13:33:50\r\n" + 
			"b.jpg, Warsaw, 2016-01-02 15:12:22\r\n" + 
			"c.jpg, Warsaw, 2016-01-02 14:34:30\r\n" + 
			"d.jpg, Warsaw, 2016-01-02 15:15:01\r\n" + 
			"e.png, Warsaw, 2016-01-02 09:49:09\r\n" + 
			"f.png, Warsaw, 2016-01-02 10:55:32\r\n" + 
			"g.jpg, Warsaw, 2016-02-29 22:13:11";

	public static void main(String[] args) {
		String data[] = input.split("\n");
		List<Image> images = Arrays.stream(data).map(img -> new Image(img)).collect(Collectors.toList());
		Map<String,Long> count = images.stream().collect(Collectors.groupingBy(Image::getCity,Collectors.counting()));
		int i=1;
		for(Image currImage : images) {
			currImage.setOrderIndex(i++);
			currImage.setCityCount(count);
		}
		images.sort((o1,o2) -> o1.getCity().compareTo(o2.getCity()) != 0 ?  o1.getCity().compareTo(o2.getCity()) : o1.getCreated().compareTo(o2.getCreated()));
		i=1;
		Image prevImage = null;
		for(int j=0;j<images.size();j++) {
			Image currImage = images.get(j);
			if(prevImage != null && !prevImage.getCity().equals(currImage.getCity())) {
				i=1;
			}
			currImage.setCityIndex(i++);
			prevImage = currImage;
		}
		images.sort((o1,o2) -> o1.getOrderIndex().compareTo(o2.getOrderIndex()));
		StringBuffer response = new StringBuffer();
		images.stream().forEach(img->response.append(img+"\n"));
		System.out.println(response.toString());
	}

	private static class Image {

		private String name;
		private String city;
		private Date created;
		private String extension;
		private Integer orderIndex;
		private Integer cityCount;
		private Integer cityIndex;
		
		public Image(String img) {
			try {
				String partitions[] = img.split(", ");
				this.name = partitions[0].split("\\.")[0];
				this.extension = partitions[0].split("\\.")[1];
				this.city = partitions[1];
				this.created = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(partitions[2]);
			} catch (ParseException e) {

			}
		}

		public void setCityIndex(int cityIndex) {
			this.cityIndex = cityIndex;
		}

		public Integer getOrderIndex() {
			return orderIndex;
		}

		public void setCityCount(Map<String, Long> count) {
			this.cityCount = count.get(city).toString().length();
		}

		public String getCity() {
			return city;
		}

		public Date getCreated() {
			return created;
		}

		@Override
		public int hashCode() {
		  return this.city.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			Image prevImage = (Image)obj;
			return this.city.equals(prevImage.city);
		}
		
		public void setOrderIndex(Integer index) {
			this.orderIndex = index;
		}
		
		@Override
		public String toString() {
			return this.city+String.format("%0"+this.cityCount+"d",this.cityIndex)+"."+this.extension;
		}
	}
}
