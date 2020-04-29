package com.api.programs;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import com.api.files.Payload;
import com.api.reusablemethods.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
//import static org.hamcrest.Matchers.*;

public class PostPlace {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		// Post Method
		String postResponse = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.addPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();
		System.out.println("Response Values :" + postResponse);

		JsonPath rawToJson = ReusableMethods.rawToJson(postResponse);
		String placeID = rawToJson.getString("place_id");
		System.out.println(placeID);

		String newAddress = "70 Summer Walk, USA";

		// Put Method
		String updateResponse = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.updateAddress(placeID, newAddress)).when().put("maps/api/place/update/json").then()
				.assertThat().statusCode(200).extract().response().asString();

		System.out.println(updateResponse);

		String msg = new JsonPath(updateResponse).getString("msg");
		System.out.println(msg);

		// Get Method
		String getResponse = given().queryParam("key", "qaclick123").queryParam("place_id", placeID).when()
				.get("maps/api/place/get/json").then().assertThat().statusCode(200).extract().response().asString();

		String updatedAddress = new JsonPath(getResponse).getString("address");

		Assert.assertEquals(updatedAddress, newAddress);

		// Delete Method
		given().queryParam("key", "qaclick123").body("{\n" + "	\"place_id\":\"" + placeID + "\"\n" + "}")
				.header("Content-Type", "application/json").when().delete("maps/api/place/delete/json").then()
				.assertThat().statusCode(200).body("status", equalTo("OK"));
		
		System.out.println("Record Removed Successfully");

	}

}
