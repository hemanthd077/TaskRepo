package runner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import commonChecker.CommonChecker;
import customException.CustomException;
import helper.RegexHelper;

public class RegexRunner {
	static Logger logger = Logger.getGlobal();
	
	public static void main(String[] args) {
		

		try {
			CommonChecker.loggerHandler("LogRecord");
		} catch (CustomException e) {
			e.printStackTrace();
		}
		
		logger.setLevel(Level.ALL);
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		RegexHelper regexHelper = new RegexHelper();
		do {
			regexOperation();
			try {
				choice = scanner.nextInt();
				if(choice <0 || choice >8) {
					throw new CustomException("You Entered the value greater than 8 or lesser than 0.");
				}
				
				switch(choice) {
					case 1:{
						scanner.nextLine();
						logger.info("Enter the Mobile Number : ");
						String mobileNumber = scanner.nextLine();
						if(regexHelper.checkValidNumber(mobileNumber)) {
							logger.log(Level.INFO,"Valid Mobile Number");
						}
						else {
							logger.log(Level.INFO,"Invalid Mobile Number");
						}
						break;
					}
					case 2:{
						scanner.nextLine();
						logger.info("Enter the String to check Alpha Numeric : ");
						String inputString = scanner.nextLine();
						if(regexHelper.checkValidAlphaNumeric(inputString)) {
							logger.log(Level.INFO,"Valid!! input String is AlphaNumeric");
						}
						else {
							logger.log(Level.INFO,"Invalid, Not input String is AlphaNumeric");
						}
						break;
					}
					case 3:{
						scanner.nextLine();
						logger.info("Enter the String 1: ");
						String inputStringOne = scanner.nextLine();
						logger.info("Enter the String 2: ");
						String inputStringTwo = scanner.nextLine();
						if(regexHelper.startsWith(inputStringOne,inputStringTwo)) {
							logger.log(Level.INFO,"Valid!! string1 starts with string2");
						}
						else {
							logger.log(Level.INFO,"Invalid, string1 not starts with string string2");
						}
						
						if(regexHelper.endsWith(inputStringOne,inputStringTwo)) {
							logger.log(Level.INFO,"Valid!! string1 ends with string2");
						}
						else {
							logger.log(Level.INFO,"Invalid, string1 not ends with string string2");
						}
						
						if(regexHelper.checkEquals(inputStringOne,inputStringTwo)) {
							logger.log(Level.INFO,"Valid!! string1 & string2 are equal");
						}
						else {
							logger.log(Level.INFO,"Invalid, string1 & string2 are notequal");
						}
						
						if(regexHelper.checkContains(inputStringOne,inputStringTwo)) {
							logger.log(Level.INFO,"Valid!! string1 contains in string2");
						}
						else {
							logger.log(Level.INFO,"Invalid, string1 not contains in string2");
						}
						break;
					}
					case 4:{
						List<String> list = new ArrayList<>();
						logger.log(Level.INFO,"Enter the no of Strings");
						int n = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<n;i++) {
							list.add(scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Regex String");
						String regex = scanner.nextLine();
						if(regexHelper.arrayCheckEqual(list,regex)) {
							logger.log(Level.INFO,"Valid!! list contains in regex String");
						}
						else {
							logger.log(Level.INFO,"Invalid, list not contains in regex String");
						}
						break;
					}
					case 5:{
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Emailid to Validate");
						String email = scanner.nextLine();
						if(regexHelper.checkValidEmail(email)) {
							logger.log(Level.INFO,"Emailid is Valid!!");
						}
						else {
							logger.log(Level.INFO,"Emailid is Invalid");
						}
						break;
					}
					case 6:{
						List<String> list = new ArrayList<>();
						logger.log(Level.INFO,"Enter the no of Strings");
						int n = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<n;i++) {
							list.add(scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the minlength to check");
						int min = scanner.nextInt();
						logger.log(Level.INFO,"Enter the maxlength to check");
						int max = scanner.nextInt();
						if(regexHelper.checkValidLength(list,min,max)) {
							logger.log(Level.INFO,"Valid!! all the string length are in given range");
						}
						else {
							logger.log(Level.INFO,"Invalid, all the string length are not in given range");
						}
						break;
					}
					case 7:{
						List<String> string = new ArrayList<>();
						List<String> matchingString = new ArrayList<>();
						logger.log(Level.INFO,"Enter the no of Strings");
						int n = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<n;i++) {
							string.add(scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the no of matching string");
						n = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Matching Strings");
						for(int i=0;i<n;i++) {
							matchingString.add(scanner.nextLine());
						}
						
						Map<String,Integer> map = regexHelper.checkMatchingString(string,matchingString);
						printHashMap(map);
						
						break;
					}
					case 8:{
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Html tags");
						String tags = scanner.nextLine();
						
						List<String> temp = regexHelper.getTags(tags);
						
						for(String string : temp) {
							logger.log(Level.INFO,string);
						}
						
						break;
					}
					default : break;
				}
				
			}
			catch(InputMismatchException e) {
				logger.log(Level.SEVERE,"Input MissMatch Exception occured : ",e);
				scanner.nextLine();
			} catch (CustomException e) {
				logger.log(Level.SEVERE,"CustomException occured : ",e);
			}
		}
		while(choice!=0);
		logger.warning("Exited Successfully");
		scanner.close();
	}
	
	static void regexOperation() {
		logger.info("\n====== Regex Operation ======");
		logger.log(Level.INFO,"1. Mobile number validation.\n"
				+ "	i. Should have 10 numbers.\n"
				+ "	ii. First digit can start with 7 or 8 or 9 only.\n"
				+ "	iii. Should not accept string & special characters");
		logger.log(Level.INFO,"2. Accept an input string with Alpha numeric characters alone");
		logger.log(Level.INFO,"3. Accept two strings viz. a given string & a matching string.\n"
				+ "	i. Check the given string starts with the matching string\n"
				+ "	ii. Check the given string contains the matching string\n"
				+ "	iii. Check the given string ends with the matching string\n"
				+ "	iv. Check the given string is an exact match");
		logger.log(Level.INFO,"4. Accept a List of Strings, maybe with duplicates by differing only with their\n"
				+ "	case (upper or lower) & a matching String. Matching should be done\n"
				+ "	irrespective of the case");
		logger.log(Level.INFO,"5. Email validation\n"
				+ "	i. Should have a \"@\" character & it should be between two strings\n"
				+ "	ii. Should have a \".\" character & it should be between two strings");
		logger.log(Level.INFO,"6. Accept a List of Strings & check whether they are only Strings with length\n"
				+ " 	ranging from 1 to 6.");
		logger.log(Level.INFO,"7. Accept a List of given Strings viz.List1 (10 nos) & accept another List of\n"
				+ "	matching Strings viz.List2 (3 nos). Please make sure all the values in List2\n"
				+ "	should be present in List1. Return a Map with matching string as Key & their\n"
				+ "	index value in List1 as Values.");
		logger.log(Level.INFO,"8. Accept a raw HTML string as input & print the HTML tags alone. For eg.\n"
				+ " 	input string : <p>The <code>President</code> of India is the first\n"
				+ " 	citizen of our country.</p>");
		logger.log(Level.INFO,"0. Exit\n");
	}
	
	static <K,V> void printHashMap(Map<K,V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
	      logger.log(Level.INFO,entry.getKey() + ": " + entry.getValue());
	    }
	}
}
