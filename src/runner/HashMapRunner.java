package runner;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import car.Car;
import commonChecker.CommonChecker;
import customException.CustomException;
import helper.HashMapHelper;

public class HashMapRunner {
	static Logger logger = Logger.getGlobal();
	public static void main(String args[]) {
		
		try {
			CommonChecker.loggerHandler("LogRecord");
		} catch (CustomException e) {
			e.printStackTrace();
		}
		logger.setLevel(Level.ALL);
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			hashMapOperation();
			try{
				choice = scanner.nextInt();
				if(choice<0 || choice>20){
					throw new CustomException("Invalid input!! choice need to be between between 0 to 20.",new InputMismatchException("Entered less than zero or greater than 20."));
				}
				
				HashMapHelper helper = new HashMapHelper();
				switch(choice) {
					case 1:{
						Map<Object,Object> hashMap =  helper.getHashMap();
						try {
							logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						}
						catch(CustomException e) {
							logger.log(Level.SEVERE,e.getMessage(),e);
						}
						break;
					}
					case 2:{
						Map<String,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i+"", scanner.nextLine());
						}
						logger.log(Level.INFO,"The Key and Value in hashmap : ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						break;
					}
					case 3:{
						Map<Integer,Integer> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Integer");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Integer");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i, scanner.nextInt());
						}
						logger.log(Level.INFO,"The Key and Value in hashmap : ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						break;
					}
					case 4:{
						Map<String,Integer> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Integer");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Integer");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i+"", scanner.nextInt());
						}
						logger.log(Level.INFO,"The Key and Value in hashmap : ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						break;
					}
					case 5:{
						Map<String,Object> hashMap =  helper.getHashMap();
						helper.mapPut(hashMap, "1", new CommonChecker());
						helper.mapPut(hashMap, "2", new Car());
						helper.mapPut(hashMap, "3", helper);
						logger.log(Level.INFO,"The Key and Value in hashmap : ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						break;
					}
					case 6:{
						Map<String,String> hashMap =  helper.getHashMap();
						helper.mapPut(hashMap, "1", "Hello");
						helper.mapPut(hashMap, "2", "Zoho");
						helper.mapPut(hashMap, "3", null);
						logger.log(Level.INFO,"The Key and Value in hashmap : ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						break;
					}
					case 7:{
						Map<String,Object> hashMap =  helper.getHashMap();
						helper.mapPut(hashMap, "1", "Hello");
						helper.mapPut(hashMap, "2", "Zoho");
						helper.mapPut(hashMap, null, "People");
						logger.log(Level.INFO,"The Key and Value in hashmap : ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						break;
					}
					case 8:{
						Map<String,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i+"", scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Key to check");
						String keyCheck = scanner.nextLine();
						boolean index = helper.checkKeyExist(hashMap,keyCheck);
						if(index) {
							logger.log(Level.INFO,"Key Found on Hashmap");
						}
						else {
							logger.log(Level.INFO,"Key Not Exist on hashMap");
						}
						logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						break;
					}
					case 9:{
						Map<String,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i+"", scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Value to check");
						String valueCheck = scanner.nextLine();
						boolean index = helper.checkValueExist(hashMap,valueCheck);
						if(index) {
							logger.log(Level.INFO,"Value Found on Hashmap");
						}
						else {
							logger.log(Level.INFO,"Value Not Exist on hashMap");
						}
						logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						break;
					}
					case 10:{
						Map<String,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i+"", scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Value to change");
						String changeValue = scanner.nextLine();
						logger.log(Level.INFO,"Size of the HashMap before: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap before: ");
						printHashMap(hashMap);
						helper.changeAllValue(hashMap,changeValue);
						logger.log(Level.INFO,"Size of the HashMap after: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap after: ");
						printHashMap(hashMap);
						break;
					}
					case 11:{
						Map<Integer,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i, scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Existing Key to check");
						int keyCheck = scanner.nextInt();
						String Value = helper.getKeyValue(hashMap,keyCheck);
						logger.log(Level.INFO,"The Value of Respective Key : "+ Value);
						logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						break;
					}
					case 12:{
						Map<Integer,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i, scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Non Existing Key to check");
						int keyCheck = scanner.nextInt();
						String Value = helper.getKeyValue(hashMap,keyCheck);
						logger.log(Level.INFO,"The Value of Respective Key : "+ Value);
						logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						break;
					}
					case 13:{
						Map<Integer,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i, scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Key to check");
						int keyCheck = scanner.nextInt();
						logger.log(Level.INFO,"Size of the HashMap before: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap before: ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"");
						helper.getWordWhileNull(hashMap,keyCheck,"Zoho");
						logger.log(Level.INFO,"Size of the HashMap after: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap after: ");
						printHashMap(hashMap);
						break;
					}
					case 14:{
						Map<Integer,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i, scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Key to Remove");
						int key = scanner.nextInt();
						logger.log(Level.INFO,"Size of the HashMap before: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap before: ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"");
						helper.mapRemoveKey(hashMap,key);
						logger.log(Level.INFO,"Size of the HashMap after: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap after: ");
						printHashMap(hashMap);
						break;
					}
					case 15:{
						Map<Integer,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i, scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Key to Remove (Integer)");
						int key = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Value to Remove(String)");
						String value = scanner.nextLine();
						logger.log(Level.INFO,"Size of the HashMap before: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap before: ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"");
						helper.mapRemoveKeyWithValue(hashMap,key,value);
						logger.log(Level.INFO,"Size of the HashMap after: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap after: ");
						printHashMap(hashMap);
						break;
					}
					case 16:{
						Map<Integer,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i, scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Key to replace the value");
						int key = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Value to Remove(String)");
						String value = scanner.nextLine();
						logger.log(Level.INFO,"Size of the HashMap before: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap before: ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"");
						helper.mapReplaceValue(hashMap,key,value);
						logger.log(Level.INFO,"Size of the HashMap after: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap after: ");
						printHashMap(hashMap);
						break;
					}
					case 17:{
						Map<Integer,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i, scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Key to replace the value");
						int key = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Old Value to Remove(String)");
						String oldValue = scanner.nextLine();
						logger.log(Level.INFO,"Enter the New Value to Remove(String)");
						String newValue = scanner.nextLine();
						logger.log(Level.INFO,"Size of the HashMap before: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap before: ");
						printHashMap(hashMap);
						
						logger.log(Level.INFO,"");
						
						helper.mapReplaceByExistValue(hashMap,key,oldValue,newValue);
						logger.log(Level.INFO,"Size of the HashMap after: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap after: ");
						printHashMap(hashMap);
						break;
					}
					case 18:{
						Map<Integer,String> hashMap =  helper.getHashMap();
						Map<Integer,String> newHashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i, scanner.nextLine());
						}
						logger.log(Level.INFO,"Size of the oldHashMap before: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in oldhashmap before: ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"Size of the newHashMap before: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in newhashmap before: ");
						printHashMap(newHashMap);
						
						logger.log(Level.INFO,"");
						
						helper.mapCopyAll(hashMap,newHashMap);
						logger.log(Level.INFO,"Size of the old HashMap after: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in old hashmap after: ");
						printHashMap(hashMap);
						logger.log(Level.INFO,"Size of the newHashMap after: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in newhashmap after: ");
						printHashMap(hashMap);
						break;
					}
					case 19:{
						Map<Integer,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i, scanner.nextLine());
						}
						logger.log(Level.INFO,"Size of the HashMap : "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap : ");
						printHashMap(hashMap);
						break;
					}
					case 20:{
						Map<Integer,String> hashMap =  helper.getHashMap();
						logger.log(Level.INFO,"Enter the No Of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							helper.mapPut(hashMap, i, scanner.nextLine());
						}
						logger.log(Level.INFO,"Size of the HashMap before: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap before: ");
						printHashMap(hashMap);
						
						helper.mapClearAll(hashMap);
						logger.log(Level.INFO,"Size of the HashMap after: "+ helper.getHashMapSize(hashMap));
						logger.log(Level.INFO,"The Key and Value in hashmap after: ");
						printHashMap(hashMap);
						break;
					}
					default : break;
				}
			}
			catch(InputMismatchException e) {
				logger.log(Level.SEVERE,"Enter Integer Not String",e);
				scanner.nextLine();
			}
			catch(CustomException e) {
				logger.log(Level.SEVERE,e.getMessage(),e);
			}
		}
		while(choice!=0);
		logger.log(Level.WARNING,"Exited Sucessfully");
		scanner.close();
	}
	
	static void hashMapOperation(){
		logger.log(Level.INFO,"\n==== HashMap Runner Menu ====\n");
		logger.log(Level.INFO,"1. Create a HashMap and print its size.");
		logger.log(Level.INFO,"2. Create a HashMap, add 3 key-value pairs (String), and print its size.");
		logger.log(Level.INFO,"3. Create a HashMap, add 3 key-value pairs (Integer), and print its size.");
		logger.log(Level.INFO,"4. Create a HashMap, add 3 key-value pairs (String, Integer), and print its size.");
		logger.log(Level.INFO,"5. Create a HashMap, add 3 key-value pairs (String, CustomObject), and print its size.");
		logger.log(Level.INFO,"6. Create a HashMap, add 3 keys (String) with one having a null value. Print the HashMap and its size.");
		logger.log(Level.INFO,"7. Create a HashMap, add a null key with a non-null value. Print the HashMap and its size.");
		logger.log(Level.INFO,"8. Check if a key exists in a HashMap.");
		logger.log(Level.INFO,"9. Check if a value exists in a HashMap.");
		logger.log(Level.INFO,"10. Create a HashMap, add 3 key-value pairs (String, String), change values, and print sizes before and after.");
		logger.log(Level.INFO,"11. Get the value of an existing key in a HashMap.");
		logger.log(Level.INFO,"12. Get the value of a non-existing key in a HashMap.");
		logger.log(Level.INFO,"13. Change the value to \"Zoho\" for a given non-existing key in a HashMap. Print sizes before and after.");
		logger.log(Level.INFO,"14. Remove an existing key in a HashMap. Print sizes before and after.");
		logger.log(Level.INFO,"15. Remove an existing key only if its value matches a given value in a HashMap. Print sizes before and after.");
		logger.log(Level.INFO,"16. Replace the value of an existing key in a HashMap. Print sizes before and after.");
		logger.log(Level.INFO,"17. Replace the value of an existing key only if its value matches a given value in a HashMap. Print sizes before and after.");
		logger.log(Level.INFO,"18. Transfer all keys and values from one HashMap to another. Print sizes before and after.");
		logger.log(Level.INFO,"19. Iterate over a HashMap and print all key-value pairs.");
		logger.log(Level.INFO,"20. Remove all entries in a HashMap. Print sizes before and after.");
		logger.log(Level.INFO,"0. Exit\n");
	}
	
	static <K,V> void printHashMap(Map<K,V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
	      logger.log(Level.INFO,entry.getKey() + ": " + entry.getValue());
	    }
//	logger.log(Level.INFO,map.values());
	}
}
