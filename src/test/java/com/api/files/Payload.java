package com.api.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class Payload {

	public static String addPlace() {
		return "{\n" + "  \"location\": {\n" + "    \"lat\": -38.383494,\n" + "    \"lng\": 33.427362\n" + "  },\n"
				+ "  \"accuracy\": 50,\n" + "  \"name\": \"Frontline house\",\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\n" + "  \"address\": \"29, side layout, cohen 09\",\n"
				+ "  \"types\": [\n" + "    \"shoe park\",\n" + "    \"shop\"\n" + "  ],\n"
				+ "  \"website\": \"http://google.com\",\n" + "  \"language\": \"French-IN\"\n" + "}";
	}
	
	public static String addPlace(String name,String address) {
		return "{\n" + "  \"location\": {\n" + "    \"lat\": -38.383494,\n" + "    \"lng\": 33.427362\n" + "  },\n"
				+ "  \"accuracy\": 50,\n" + "  \"name\": \""+name+"\",\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\n" + "  \"address\": \""+address+"\",\n"
				+ "  \"types\": [\n" + "    \"shoe park\",\n" + "    \"shop\"\n" + "  ],\n"
				+ "  \"website\": \"http://google.com\",\n" + "  \"language\": \"French-IN\"\n" + "}";
	}

	public static String updateAddress(String placeID,String address) {

		return "{\n" + 
				"	\"place_id\":\""+placeID+"\",\n" + 
				"	\"key\":\"qaclick123\",\n" + 
				"	\"address\":\""+address+"\"\n" + 
				"}";
	}
	
	public static String mockJsonResponse()
	{
		return "{\n" + 
				"\"dashboard\": {\n" + 
				"\"purchaseAmount\": 2860,\n" + 
				"\"website\": \"rahulshettyacademy.com\"\n" + 
				"},\n" + 
				"\"courses\": [\n" + 
				"{\n" + 
				"\"title\": \"Selenium Python\",\n" + 
				"\"price\": 50,\n" + 
				"\"copies\": 6\n" + 
				"},\n" + 
				"{\n" + 
				"\"title\": \"RPA\",\n" + 
				"\"price\": 40,\n" + 
				"\"copies\": 4\n" + 
				"},\n" + 
				"{\n" + 
				"\"title\": \"Cypress\",\n" + 
				"\"price\": 45,\n" + 
				"\"copies\": 10\n" + 
				"},\n" + 
				"{\n" + 
				"\"title\": \"Appium\",\n" + 
				"\"price\": 65,\n" + 
				"\"copies\": 30\n" + 
				"}\n" + 
				"]\n" + 
				"}\n" + 
				"";
	}
	
	public static String addBook() {
		return "{\n" + 
				"\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\n" + 
				"\"isbn\":\"bcd\",\n" + 
				"\"aisle\":\"227\",\n" + 
				"\"author\":\"John foe\"\n" + 
				"} \n" + 
				"";
	}
	
	public static String getJsonDataFromPath(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
	public static LinkedHashMap<String,String> params(){
		
		LinkedHashMap<String,String> map=new LinkedHashMap<>();
		map.put("key", "qaclick123");
		
		return map;
		
	}
}
