package com.api.programs;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import com.api.pojos.JiraAuthenticationPojo;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetJiraSession {

	public static void main(String[] args) {

		JiraAuthenticationPojo jap = new JiraAuthenticationPojo();
		jap.setUsername("isainew");
		jap.setPassword("Esai@8289");	


		RestAssured.baseURI = "http://localhost:8080";
		RestAssured.authentication = RestAssured.preemptive().basic("isainew",
				"L2SEsRZWq8RiXbmtJDcG5639");

		SessionFilter session = new SessionFilter();

		String asString = given().contentType(ContentType.JSON).
		body(jap).filter(session).when().post("rest/auth/1/session").then().extract().response().asString();
		System.out.println(asString);

	
		
		
	}

}
