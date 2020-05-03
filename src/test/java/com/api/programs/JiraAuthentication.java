package com.api.programs;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import com.api.pojos.JiraAuthenticationPojo;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JiraAuthentication {

	public static void main(String[] args) {

		JiraAuthenticationPojo jap = new JiraAuthenticationPojo();
		jap.setUsername("isainew");
		jap.setPassword("Esai@8289");

		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Authorization", "Basic aXNhaW5ldzpFc2FpQDgyODk=");

//		 http://localhost:8080/rest/auth/1/session
//
//		RestAssured.baseURI = "http://localhost:8080";
//		RestAssured.authentication = RestAssured.preemptive().basic("isainew",
//				"RXNhaUA4Mjg5");
//
//		SessionFilter session = new SessionFilter();
//
//		String asString = given().headers(headerMap).
//		body(jap).filter(session).when().post("rest/auth/1/session").then().extract().response().asString();
//		System.out.println(asString);

		// Step 1: Get the URL / Endpoint for the services
		RestAssured.baseURI = "https://api-mar2020.atlassian.net/rest/api/2/";

		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com",
				"kEJxzmhkQzvdeP8iysWN2D1B");
		
		 String asString = given().contentType(ContentType.JSON).body("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"MAR\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"New Defect.\",\r\n" + 
				"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}").when().log().all()
		.post("issue").then().log().all().extract().response().asString();
		 
		 System.out.println(asString);
		
		
	}

}
