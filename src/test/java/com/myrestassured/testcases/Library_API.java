package com.myrestassured.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import payload.ReusuableMethod;
import payload.JSON_payload;

public class Library_API {
	
	@Test
	public void total_purchase_amount() {
		
		JsonPath js1 = ReusuableMethod.RawToJson(JSON_payload.library_payload_responseMsg());
	
		System.out.println("The total purchase amount is: "  + " "+ js1.getInt("dashboard.purchaseAmount" ));
	}
	
	@Test
	public void number_of_courses() {
		JsonPath js1 = ReusuableMethod.RawToJson(JSON_payload.library_payload_responseMsg());
		//int count = js1.getInt("courses.size()");
		System.out.println("The number of courses are:" + " " + js1.getInt("courses.size()"));
		
	}

	@Test
	public void title_of_first_course()
	{
		JsonPath js1 = ReusuableMethod.RawToJson(JSON_payload.library_payload_responseMsg());
		
		System.out.println("The title of first course is:" + " " + js1.getString("courses[0].title"));
	}
	
/*	@Test
	public void course_title_prices() {
		
		JsonPath js1 = ReusuableMethod.RawToJson(JSON_payload.library_payload_responseMsg());
		int count = js1.getInt("courses.size()");
		
		for(int i=0;i<count;i++) {
			
			System.out.println("The title of the course is: "+" " + js1.get("courses[" + i+"].title")+ "\n" 
			+ "The title of the price is: "+ " "+ js1.getInt("courses["+i+"].price"));
		
			
		}
		
	}*/
	
	@Test
	public void copies_sold() {
		
		JsonPath js1 = ReusuableMethod.RawToJson(JSON_payload.library_payload_responseMsg());
		int count = js1.getInt("courses.size()");
		
		for(int i=0;i<count;i++) {
			
			if(js1.getString("courses["+i+"].title").equalsIgnoreCase("RPA")) {
			
				System.out.println("The price of " +  js1.get("courses[" + i+"].title")+ " " + "is" + " "+ js1.getInt("courses["+i+"].price"));
				break;
			}
			
			
		}
		
	}
	
	@Test
	public void sum_of_course_price() {
		
		JsonPath js1 = ReusuableMethod.RawToJson(JSON_payload.library_payload_responseMsg());
		int count = js1.getInt("courses.size()");
		int sum=0;
		for(int i=0;i<count;i++) {
			
			int totalprice_of_book = js1.getInt("courses["+i+"].price")*js1.getInt("courses["+i+"].copies");
			sum = sum + totalprice_of_book;
			
		}
		
		System.out.println("The sum of course price is " + " "+ sum);
		assertEquals(sum, js1.getInt("dashboard.purchaseAmount"));
	}
}
