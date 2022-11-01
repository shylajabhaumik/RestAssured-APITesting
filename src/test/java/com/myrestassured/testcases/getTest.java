package com.myrestassured.testcases;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class getTest {
	
	@Test
	public void getTestMethod1()
	{
	/*	Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("As String" + response.asString());
		System.out.println("Body" + response.getBody().asString());
		System.out.println("Get Content Type" + response.getContentType());
		
		System.out.println("Status code" + response.statusCode());
		System.out.println("Status line" + response.statusLine());
		System.out.println("Get Statuscode" + response.getStatusCode());
		System.out.println("Get StatusLIne" + response.getStatusLine());
		System.out.println("Get StatusLIne" + response.getHeaders());*/
		
		  
			given().baseUri("https://reqres.in/api/users?page=2")
			.when().get()
			.then().assertThat().statusCode(200).log().all()
			.body("data.avatar[0]", 
					equalTo("https://reqres.in/img/faces/1-image.jpg"));
		
	}

}
