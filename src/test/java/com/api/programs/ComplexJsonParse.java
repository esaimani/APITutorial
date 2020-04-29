package com.api.programs;

import org.testng.Assert;

import com.api.files.Payload;
import com.api.reusablemethods.ReusableMethods;

import io.restassured.path.json.JsonPath;


public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath rawToJson = ReusableMethods.rawToJson(Payload.mockJsonResponse());

		// Print No of courses returned by API
		int coursecount = rawToJson.getInt("courses.size");
		System.out.println(coursecount);

		// Print Purchase Amount
		System.out.println(rawToJson.getString("dashboard.purchaseAmount"));

		// Print Title of the first course
		System.out.println(rawToJson.getString("courses[2].title"));

		// Print the all values in course Array
		for (int i = 0; i < coursecount; i++) {
			System.out.println("Course Title is : " + rawToJson.getString("courses[" + i + "].title") + ", Price is : "
					+ rawToJson.getString("courses[" + i + "].price") + ", Total Copies are : "
					+ rawToJson.getString("courses[" + i + "].copies"));
		}

		// Print no of copies sold by RPA Course
		for (int i = 0; i < coursecount; i++) {
			if (rawToJson.getString("courses[" + i + "].title").equals("RPA")) {
				System.out.println("Total RPA Copies are : " + rawToJson.getString("courses[" + i + "].copies"));
				break;
			}

		}

		// Verify if Sum of all Course prices matches with Purchase Amount
		int sum = 0;
		for (int i = 0; i < coursecount; i++) {

			int courseprice = rawToJson.getInt("courses[" + i + "].price");
			int copies = rawToJson.getInt("courses[" + i + "].copies");

			sum = sum + (courseprice * copies);
		}
		System.out.println(sum);
		
	Assert.assertEquals(String.valueOf(sum), rawToJson.getString("dashboard.purchaseAmount"),"Purchase Amount Mismatched");

	}

}
