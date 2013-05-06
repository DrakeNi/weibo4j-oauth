package weibo4j.examples.WeiboCrawler;

import java.sql.Timestamp;
import java.util.Date;


public class GetCurrentTimeStamp {
	
	public static void main(String[] args){
		
		java.util.Date date = new java.util.Date();
		long d = date.getTime() - 60*60*1000;
		System.out.println(new Timestamp(date.getTime()));
		System.out.println(new Timestamp(d));
		
		System.out.println(date.getTime());
		
		System.out.println(System.currentTimeMillis());
		
		System.out.println(new Timestamp(System.currentTimeMillis()));
		
		System.out.println(date.getTime());
		
	}
	
	

}
