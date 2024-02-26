package json;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import commonChecker.CommonChecker;
import customException.CustomException;
import serializingDeserializing.TaskHelper;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonOperation {
	static Logger logger = Logger.getGlobal();
	public static void main(String... args) {
		try {
			CommonChecker.loggerHandler("LogRecord");
		} catch (CustomException e) {
			e.printStackTrace();
		}
		logger.setLevel(Level.ALL);
		
		TaskHelper taskHelper = new TaskHelper();
		
		Scanner scanner = new Scanner(System.in);
		try {
			int choice=0;
			do {
					operationMenu();
					choice = scanner.nextInt();
					switch(choice) {
						case 1:{
							
							JSONObject obj = new JSONObject();
							obj.put("Name","hemanth");
							obj.put("Age", 20);
							
							JSONArray tempArray = new JSONArray();
							
							tempArray.put("surya");
							tempArray.put("Ajit");
							tempArray.put("Bharath");
							obj.put("Buddy", tempArray);
							
							taskHelper.serializingJSON(obj, "object.json");
							
							System.out.println("Name : "+obj.get("Name"));
							System.out.println("Buddy : "+obj.get("Buddy"));
							System.out.println("Age : "+obj.get("Age")+"\n");
							
							JSONObject result = taskHelper.deserializingJSON("object.json");
							
							System.out.println(result+"\n");
							
							System.out.println("Name : "+result.get("Name"));
							System.out.println("Buddy : "+result.get("Buddy"));
							System.out.println("Age : "+result.get("Age")+"\n");
							System.out.println("result : "+result.optBoolean("Name1", false));
							
							Map<String, Object> data = new HashMap<>();
							 data.put( "name", "Mars" );
							 data.put( "age", 32 );
							 data.put( "city", "NY" );
							
							 JSONObject tempArr = new JSONObject();
							 tempArr.put("hello",data.values());
							System.out.println("Temp Arr : "+tempArr.toString());
							
							break;
						}
						
						case 2:{
							String jsonData = "{\n"
									+ "    \"annotations\": [\n"
									+ "        {\n"
									+ "           \"start\": 144,\n"
									+ "           \"end\": 150,\n"
									+ "           \"probability\": 0.626,\n"
									+ "           \"type\": \"Product\",\n"
									+ "           \"normalized_text\": \"Twitter\"\n"
									+ "        },\n"
									+ "        {\n"
									+ "            \"start\": 18,\n"
									+ "            \"end\": 23,\n"
									+ "            \"tag\": \"twtr\"\n"
									+ "        }\n"
									+ "    ],\n"
									+ "   \"cashtags\": [\n"
									+ "        {\n"
									+ "            \"start\": 18,\n"
									+ "            \"end\": 23,\n"
									+ "            \"tag\": \"twtr\"\n"
									+ "        }\n"
									+ "    ],\n"
									+ "    \"hashtags\": [\n"
									+ "        {\n"
									+ "            \"start\": 0,\n"
									+ "            \"end\": 17,\n"
									+ "            \"tag\": \"blacklivesmatter\"\n"
									+ "        }\n"
									+ "    ],\n"
									+ "    \"mentions\": [\n"
									+ "        {\n"
									+ "            \"start\": 24,\n"
									+ "            \"end\": 35,\n"
									+ "            \"tag\": \"TwitterDev\"\n"
									+ "        }\n"
									+ "    ],\n"
									+ "    \"urls\": [\n"
									+ "        {\n"
									+ "           \"start\": 44,\n"
									+ "           \"end\": 67,\n"
									+ "           \"url\": \"https://t.co/crkYRdjUB0\",\n"
									+ "           \"expanded_url\": \"https://twitter.com\",\n"
									+ "           \"display_url\": \"twitter.com\",\n"
									+ "           \"status\": \"200\",\n"
									+ "           \"title\": \"bird\",\n"
									+ "           \"description\": \"From breaking news and entertainment to sports and politics, get the full story with all the live commentary.\",\n"
									+ "            \"unwound_url\": \"https://twitter.com\"\n"
									+ "        }\n"
									+ "    ]\n"
									+ "}";

					        // Parse the JSON string into a JSONObject
					        JSONObject jsonObject = new JSONObject(jsonData);
					        System.out.println(jsonObject.toString(2));
					        JSONArray dummy = jsonObject.getJSONArray("annotations");
					        int len =dummy.length();
					        for(int i=0;i<len;i++) {
					        	System.out.println("START : "+dummy.getJSONObject(i).get("start"));
					        }
//					        System.out.println(jsonObject.getJSONArray("annotations").getJSONObject(1).get("start"));
						        break;
						}
						case 3:{							 
							 JSONObject jsonObject = new JSONObject();
						        jsonObject.put("name", JSONObject.quote("John \"Doe\""));
						        jsonObject.put("address", JSONObject.quote("123 \\ Main St"));

						        // Convert JSONObject to string
						        String jsonString = jsonObject.toString();
						        System.out.println(jsonString);
						        System.out.println("JSON String: " + jsonObject.get("name"));
							break;
						}
//						case 4:{
//							String inputString = "Hello World and ; are special characters";
//
//					        // Escape the input string
//					        String escapedString = Cookie.escape(inputString);
//
//					        // Print the escaped string
//					        System.out.println("Escaped String: " + escapedString);
//					        escapedString = Cookie.unescape(escapedString);
//					        System.out.println(escapedString);
//					        break;
//						}
//						case 5:{
//							JSONObject obj = new JSONObject();
//							obj.put("Name","hemanth");
//							obj.put("Age", 20);
//					        Properties encodedQueryString = Property.toProperties(obj);
//					        System.out.println("Encoded Query String: " + encodedQueryString.getProperty("Name"));
//					        
//							break;
//						}
						default:break;
					}
			}
			while(choice>0 && choice<12);
		}
		catch(InputMismatchException e) {
			logger.log(Level.SEVERE,"Input mis match entred : ",e);
			scanner.nextLine();
		}
		catch(CustomException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,e.getMessage(),e.getCause());
		}
		logger.log(Level.WARNING,"Exited successfully");
		scanner.close();
	}
	private static void operationMenu() {
		logger.info("==== JSON operation ====");
		logger.info("1. Creating Json Object");
	}
}
