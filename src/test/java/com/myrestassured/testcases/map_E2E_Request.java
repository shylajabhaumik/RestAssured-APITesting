package com.myrestassured.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import payload.JSON_payload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class map_E2E_Request {
	
	@Test
	public void E2E_request() {
		//Post
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		System.out.println("Post request");
	String response =  given().body(JSON_payload.maps_payload_PostRequestMsg()).queryParam("key", "qaclick123").log().all().
	 when().post("/maps/api/place/add/json").
	 then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = new JsonPath(response);
		String place_id = js.get("place_id");
		System.out.println("The extracted place_id is:" + " "+ place_id);
		
		
		//Put
		
	/*	given().log().all().queryParam("key", "qaclick123").body("{\n"
				+ "\"place_id\":\""+place_id+"\",\n"
				+ "\"address\":\"70 Summer walk, USA\",\n"
				+ "\"key\":\"qaclick123\"\n"
				+ "}").
		when().put("/maps/api/place/update/json").
		then().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));*/
		
//*************//
		System.out.println("Put request");
		given().log().all().queryParam("key", "qaclick123").body(JSON_payload.maps_payload_PutRequestMsg(place_id)).
		when().put("/maps/api/place/update/json").
		then().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get
		System.out.println("Get request");
		given().log().all().queryParam("place_id", place_id).queryParam("key", "qaclick123").
		when().get("/maps/api/place/get/json").
		then().log().all().body("address", equalTo("70 Summer walk, USA")).statusCode(200);
		
		System.out.println("Get request using JSON extract");
		String getResponse = given().log().all().queryParam("place_id", place_id).queryParam("key", "qaclick123").
		when().get("/maps/api/place/get/json").
		then().log().all().body("address", equalTo("70 Summer walk, USA")).statusCode(200).extract().body().asString();
		
		JsonPath js1 = new JsonPath(getResponse);
		String address = js1.get("address");
		System.out.println("The extracted address:" + " " + address);
		Assert.assertEquals(address, "70 Summer walk, USA");
		
		
	}

}
