package com.myrestassured.testcases;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import groovy.json.JsonBuilder;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class postTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void postTest1() {
	
	//Unordered list 
	/*Map<String, Object> mp = new HashMap<String, Object>();
	mp.put("firstname", "Shylaja");
	mp.put("lastname", "Bhaumik");
	mp.put("job", "Automation Tester");
	mp.put("list", "Unordered");
	
	//Order list
	LinkedHashMap<String, Object> lm = new LinkedHashMap<String, Object>();
	lm.put("firstname", "Shylaja");
	lm.put("lastname", "Bhaumik");
	lm.put("job", "Automation Tester");
	lm.put("list", "Ordered");
	
	
	System.out.println("Unordered list" + mp);
	System.out.println("Ordered list" + lm);*/

/*	JsonBuilder jb = new JsonBuilder(lm);
	JsonBuilder jb1 = new JsonBuilder(mp);
	JSONObject jo = new JSONObject(lm);
	JSONObject jo1 = new JSONObject(mp);
	System.out.println(lm);
	System.out.println(mp);*/
	
	
/*	JSONObject jobj = new JSONObject();
	jobj.put("NAME", "SHYLAJA");
	jobj.put("NAME1", "BHAUMIK");
	jobj.put("Skill", "API Automation - RestAssured");
	System.out.println(jobj.toJSONString());*/
	JSONObject jobj1 = new JSONObject();
	jobj1.put("name", "Shylaja Bhaumik");
	jobj1.put("job", "Automation Tester");
	
	//given().body(jobj.toJSONString()).when().post("https://reqres.in/api/users").then().assertThat().statusCode(201).log().all();
	given().body(jobj1.toJSONString())
	.when().post("https://reqres.in/api/users")
	.then().assertThat().statusCode(201).log().all();
	
	

}
}