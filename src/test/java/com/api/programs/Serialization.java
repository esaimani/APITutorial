package com.api.programs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import com.api.pojos.BodyParams;
import com.api.pojos.Courses;
import com.api.pojos.Dashboard;

public class Serialization {

	public static void main(String[] args) {

		BodyParams bp = new BodyParams();
		Dashboard db = new Dashboard();
		db.setPurchaseAmount("200");
		db.setWebsite("www.Linkedin.com");
		bp.setDashboard(db);

		Courses cs = new Courses();
		cs.setCopies(50);
		cs.setPrice(100);
		cs.setTitle("Java");
		
		Courses cs1 = new Courses();
		cs1.setCopies(70);
		cs1.setPrice(300);
		cs1.setTitle("Python");
		
		System.out.println();
		
		List<Courses> list = new ArrayList<>();
		list.add(cs);
		list.add(cs1);
		
		bp.setCourses(list);
		
		String postResponse = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(bp).log().all().when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();
		System.out.println("Response Values :" + postResponse);
		
		
		
		

	}

}
