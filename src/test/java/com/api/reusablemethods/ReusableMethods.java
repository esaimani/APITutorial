package com.api.reusablemethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	public static JsonPath rawToJson(String response)
	{
		return new JsonPath(response);
	}

	
}
