package com.api.programs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.files.Payload;
import com.api.reusablemethods.ReusableMethods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetBodyFromJsonFile {
	
	@Test
	public void addBook() throws IOException
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String jsonPath="./src/test/java/com/api/files/StaticJson.json";

		// Post Method
		String postResponse = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.getJsonDataFromPath(jsonPath)).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();
		System.out.println("Response Values :" + postResponse);
		
		JsonPath rawToJson = ReusableMethods.rawToJson(postResponse);
		String placeID = rawToJson.getString("place_id");
		System.out.println(placeID);
		
		// Delete Method
				given().queryParam("key", "qaclick123").body("{\n" + "	\"place_id\":\"" + placeID + "\"\n" + "}")
						.header("Content-Type", "application/json").when().delete("maps/api/place/delete/json").then()
						.assertThat().statusCode(200).body("status", equalTo("OK"));
				
				System.out.println("Record Removed Successfully");
		
	}

}
