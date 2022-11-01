package com.myrestassured.testcases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payload.JSON_payload;

import static io.restassured.RestAssured.*;


public class User_Registration {
	
	@BeforeTest
	public static void URL() {
		RestAssured.baseURI = "https://reqres.in/api/users";
	}
	
	//Dynamically build JSON wiht external data inputs//
	@Test
	public static void user_registration() {
		
	/*	String message = JSON_payload.registration_request_payload("abc@test.com", "ABC123");
		System.out.println(message);*/
		
		given().log().all().body(JSON_payload.registration_request_payload("SB","Automation Tester")).
		when().post().
		then().log().all().assertThat().statusCode(201).extract().body().asString();
		
	}
	//Parameterize the API tests with multiple datasets//
	@Test(dataProvider = "userData")
	public static void user_registration_data_parameter(String user, String job) {
		
	/*	String message = JSON_payload.registration_request_payload("abc@test.com", "ABC123");
		System.out.println(message);*/
		
		given().log().all().body(JSON_payload.registration_request_payload(user,job)).
		when().post().
		then().log().all().assertThat().statusCode(201).extract().body().asString();
		
	}
	@DataProvider(name="userData")
	
	public Object[][] data() {
		
		return new Object[][] {{"abc","bca"},{"bcd","dcb"},{"cde","edc"}};
		
	}
	

}
