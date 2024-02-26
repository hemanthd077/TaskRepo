package runner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import commonChecker.CommonChecker;

import java.util.List;
import java.util.InputMismatchException;
import customException.CustomException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.IOException;
import helper.StringHelper;

public class StringRunner{
	private static Logger logger = Logger.getGlobal();
	public static void main(String[] args){
	
		try {
			CommonChecker.loggerHandler("LogRecord");
		} catch (CustomException e) {
			e.printStackTrace();
		}
		
		logger.setLevel(Level.ALL);
		
		Scanner scanner = new Scanner(System.in);
		int choice=0;
		StringHelper taskHelper = new StringHelper();
		do{
			logger.log(Level.INFO,"-----------------------------------------------------------------------------------------------------------------------------------");
			displayChoice();
			try{
				choice = scanner.nextInt();
				if(choice<0 || choice>20){
					throw new CustomException("ArithmeticException Occured because of ",new IOException("You entered denominator as Zero"));
				}
			}
			catch(InputMismatchException e){
				logger.log(Level.SEVERE,"Enter the Integer not string",e);
				scanner.nextLine();
			}
			catch(CustomException e){
				logger.log(Level.SEVERE,e.getMessage(),e);
				logger.log(Level.SEVERE,e.getCause()+"\n",e);
				
				e.printStackTrace();
			}
			switch(choice){
				case 1:{
					try{
						logger.log(Level.INFO,"The String : "+args[0]);
						logger.log(Level.INFO,"The length of the String : "+taskHelper.findLength(args[0]));
					}
					catch(CustomException | ArrayIndexOutOfBoundsException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 2:{
					logger.log(Level.INFO,"Enter the String :");
					String inputString = scanner.next();
					try{
						char[] charArray = taskHelper.stringToCharArray(inputString);
						for(char character : charArray){
							logger.log(Level.INFO,character+"");
						}
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 3:{
					logger.log(Level.INFO,"Enter the String to Find penultimate :");
					String inputString = scanner.next();
					try{
						char resultCharacter = taskHelper.penultimateFinder(inputString,2);
						logger.log(Level.INFO,"The penultimate result : "+resultCharacter);
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 4:{
					logger.log(Level.INFO,"Enter the String :");
					String inputString = scanner.next();
					logger.log(Level.INFO,"Enter the letter/character");
					char inputCharacter =scanner.next().charAt(0);
					try{
						logger.log(Level.INFO,"The occurance of Character on the String : ");
						logger.log(Level.INFO,taskHelper.frequencyFinder(inputString,inputCharacter)+"\n");
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 5:{
					logger.log(Level.INFO,"Enter the String :");
					String inputString = scanner.next();
					logger.log(Level.INFO,"Enter the letter/character");
					char inputCharacter =scanner.next().charAt(0);
					try{
						int resultIndex = taskHelper.greatestPositionOccured(inputString,inputCharacter);
						if(resultIndex==-1){
							logger.log(Level.INFO,"letter not occured on the string");
						}
						else{
							logger.log(Level.INFO,"The greatest Position of Character on the String : "+ resultIndex);	
						}
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;	
				}
				case 6 :{
					logger.log(Level.INFO,"Enter the String:");
					String inputString = scanner.next();
					logger.log(Level.INFO,"Enter the N to get last");
					try{
						int lastN = scanner.nextInt();
						String result = taskHelper.lastNChar(inputString,lastN);
						logger.log(Level.INFO,"The occurance of Character on the String : "+ result);
					}
					catch(InputMismatchException e){
						logger.log(Level.SEVERE,"Enter the Integer not String",e);
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
						scanner.nextLine();
					}
					break;
				}
				case 7:{
					logger.log(Level.INFO,"Enter the String:");
					String inputString = scanner.next();
					logger.log(Level.INFO,"Enter the Nth Postion");
					try{
						int firstN = scanner.nextInt();
						String result = taskHelper.firstNChar(inputString,firstN);
						logger.log(Level.INFO,"The First "+firstN+" occurance of the String: "+ result);
					}
					catch(InputMismatchException e){
						logger.log(Level.SEVERE,"Enter the Integer not String",e);
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
						scanner.nextLine();
					}
					break;
				}
				case 8:{
					logger.log(Level.INFO,"Enter the String of first N character to Replace:");
					String inputString = scanner.next();
					logger.log(Level.INFO,"Enter the Replace String");
					String replaceString = scanner.next();
					logger.log(Level.INFO,"Enter the total letter to replace from front");
					try{
						int totalLetter = scanner.nextInt();
						String result = taskHelper.replaceFront(inputString,replaceString,totalLetter);
						logger.log(Level.INFO,result);
					}
					catch(InputMismatchException e){
						logger.log(Level.SEVERE,"Enter the Integer not String",e);
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
						scanner.nextLine();
					}
					break;
				}
				case 9:{
					logger.log(Level.INFO,"Enter the String to check starts with some String:");
					String inputString = scanner.next();
					logger.log(Level.INFO,"Enter the stringPattern to check");
					String someString = scanner.next();
					try{
						if(taskHelper.stringStartsWith(inputString,someString)){
							logger.log(Level.INFO,"starts with "+someString);
						}
						else{
							logger.log(Level.INFO,"String not Starts with "+someString);
						}
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 10:{
					logger.log(Level.INFO,"Enter the String to check ends with some String:");
					String inputString = scanner.next();
					logger.log(Level.INFO,"Enter the stringPattern to check");
					String someString = scanner.next();
					try{
						if(taskHelper.stringEndsWith(inputString,someString)){
							logger.log(Level.INFO,"String ends with "+someString);
						}
						else{
							logger.log(Level.INFO,"String not ends with "+someString);
						}
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 11:{
					try{
						logger.log(Level.INFO,"Enter the String for convert to Uppercase:");
						String inputString = scanner.next();
						logger.log(Level.INFO,"Converted string to UpperCase : "+taskHelper.toUpper(inputString));
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 12:{
					try{
						logger.log(Level.INFO,"Enter the String for convert to Lowercase:");
						String inputString = scanner.next();
						logger.log(Level.INFO,"Converted String to LowerCase : "+taskHelper.toLower(inputString));
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 13:{
					try{
						logger.log(Level.INFO,"Enter the String to Reverse:");
						String inputString = scanner.next();
						logger.log(Level.INFO,"Reversing the result is : "+(taskHelper.toReverseString(inputString)));
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 14:{
					logger.log(Level.INFO,"Enter the Multiple String in Single Line:");
					String inputString = scanner.nextLine();
					logger.log(Level.INFO,"Result by accepting a line with multiple Strings : "+inputString);
					break;
				}
				case 15:{
					scanner.nextLine();
					logger.log(Level.INFO,"Enter the String :");
					String inputString = scanner.nextLine();
					logger.log(Level.INFO,"Enter toSelect the replace character");
					String replaceCharacter = scanner.nextLine();
					logger.log(Level.INFO,"Enter the replacecharacter to Replace");
					String replaceedCharacter = scanner.nextLine();
					logger.log(Level.INFO,"Result by accepting a line with multiple Strings and concatenated : ");
					try{
						logger.log(Level.INFO,taskHelper.stringConcateWithReplace(inputString,replaceCharacter,replaceedCharacter)+"\n");
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 16:{
					scanner.nextLine();
					logger.log(Level.INFO,"Enter the String :");
					String inputString = scanner.nextLine();
					logger.log(Level.INFO,"Enter the Pattern character to remove");
					String replaceCharacter = scanner.nextLine();
					try{
						logger.log(Level.INFO,"Multiple String to StringArray: "+ (taskHelper.stringToArray(inputString,replaceCharacter)));
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 17:{
					try{
						scanner.nextLine();
						List<String> arrayOfString = new ArrayList<>();
						logger.log(Level.INFO,"Enter the multiple String :");
						while(true){
							String temp = scanner.nextLine();	
							if(temp.equals("")){
								break;
							}
							arrayOfString.add(temp);
						}		
						logger.log(Level.INFO,"Enter the character to concat");
						String pattern = scanner.next();
						logger.log(Level.INFO,"String after converting to Pattern : "+taskHelper.stringToPattern(arrayOfString,pattern));
					}
					catch(InputMismatchException e){
						logger.log(Level.SEVERE,"Enter the Integer not String",e);
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 18:{
					logger.log(Level.INFO,"Enter the String one :");
					String stringOne = scanner.next();
					logger.log(Level.INFO,"Enter the String two :");
					String stringTwo = scanner.next();
					try{
						if(taskHelper.checkEqualStringWithoutCase(stringOne,stringTwo)){
							logger.log(Level.INFO,"String is Equal");
						}
						else{
							logger.log(Level.INFO,"String is not Equal");
						}
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 19:{
					logger.log(Level.INFO,"Enter the String one :");
					String stringOne = scanner.next();
					logger.log(Level.INFO,"Enter the String two :");
					String stringTwo = scanner.next();
					try{
						if(taskHelper.checkEqualStringWithCase(stringOne,stringTwo)){
							logger.log(Level.INFO,"String is Equal");
						}
						else{
							logger.log(Level.INFO,"String is not Equal");
						}
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 20:{
					logger.log(Level.INFO,"Enter the String to Trim edge:");
					String inputString = scanner.nextLine();
					try{
						logger.log(Level.INFO,"String After Trim the Edge : "+taskHelper.trimString(inputString));
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				default:break;
			}
		}
		while(choice!=0);
		logger.log(Level.WARNING,"Exited Successfully");
		scanner.close();
	}
	
	static void displayChoice(){
			logger.log(Level.INFO,"Select Your Choice here: \n\n");
			logger.log(Level.INFO,"1. Find the length of the string");
			logger.log(Level.INFO,"2. Convert String to Character array");
			logger.log(Level.INFO,"3. Find the Character at the last but one place");
			logger.log(Level.INFO,"4. Find no.of occurrences of given character");
			logger.log(Level.INFO,"5. Find the greatest position of given character");
			logger.log(Level.INFO,"6. Print last N characters of string");
			logger.log(Level.INFO,"7. Print first N characters of string");
			logger.log(Level.INFO,"8. Replace first N characters of String");
			logger.log(Level.INFO,"9. Check whether a string startswith some String");
			logger.log(Level.INFO,"10. Check whether a string endswith some String");
			logger.log(Level.INFO,"11. Convert an all lowercase string to an uppercase string");
			logger.log(Level.INFO,"12. Convert an all uppercase string to an lowercase string");
			logger.log(Level.INFO,"13. Enter the String to Reverse");
			logger.log(Level.INFO,"14. Accept a line with multiple strings");
			logger.log(Level.INFO,"15. Accept a line with multiple Strings and concatenate to single string");
			logger.log(Level.INFO,"16. Accept a line of strings and put all in array");
			logger.log(Level.INFO,"17. Accept multiple strings and merge each string with some character in between");
			logger.log(Level.INFO,"18. Check two strings are equal (Case sensitive)");
			logger.log(Level.INFO,"19. Check two strings are equal (Case insensitive)");
			logger.log(Level.INFO,"20. Enter the String to trim the extra space space front and rear");
			logger.log(Level.INFO,"0. Enter to Zero : Exit\n");
	
	}
	
}
