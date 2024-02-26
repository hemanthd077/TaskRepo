package runner;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import commonChecker.CommonChecker;

import java.util.InputMismatchException;
import customException.CustomException;
import helper.StringBuilderHelper;

public class StringBuilderRunner{
	private static Logger logger = Logger.getGlobal();
	public static void main(String[] args) {
		
		try {
 			CommonChecker.loggerHandler("LogRecord");
 		} catch (CustomException e) {
 			e.printStackTrace();
 		}
 		logger.setLevel(Level.ALL);
		
		Scanner scanner = new Scanner(System.in);
		StringBuilderHelper stringBuilderHelper = new StringBuilderHelper();
		int choice=0;
		do{
			logger.log(Level.INFO,"-----------------------------------------------------------------------------------------------------------------");
			taskDisplay();
			try{
				choice = scanner.nextInt();
				if(choice<0 || choice>11){
					throw new CustomException("Invalid input!! choice need to be between between 0 to 10.",new InputMismatchException("Entered less than zero or greater than 10."));
				}
			}
			catch(InputMismatchException e){
				logger.log(Level.SEVERE,"InputMismatchException : you entered string rather than number",e);
			}
			catch(CustomException e){
				logger.log(Level.SEVERE,"Exception :"+e.getMessage(),e);
				logger.log(Level.SEVERE,"Cause by :"+e.getCause().getMessage());
			}
			
			switch(choice){
				case 1:{
					try{
						StringBuilder stringBuilder = StringBuilderHelper.getStringBuilder();
						logger.log(Level.INFO,"Enter the String to Append in StringBuilder : ");
						scanner.nextLine();
						String inputString = scanner.nextLine();
						logger.log(Level.INFO,"The Empty String Builder Length : "+stringBuilderHelper.stringBuilderLength(stringBuilder));
						
						stringBuilder = stringBuilderHelper.appendValue(stringBuilder,inputString);
						
						logger.log(Level.INFO,"The After the adding string Length: "+stringBuilderHelper.stringBuilderLength(stringBuilder));
						logger.log(Level.INFO,"The Final String is : "+stringBuilderHelper.buildertoString(stringBuilder));
					}
					catch(CustomException e ){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 2:{
					logger.log(Level.INFO,"Enter the String to Append in StringBuilder : ");
					try{
						scanner.nextLine();
						String inputString = scanner.nextLine();
						StringBuilder stringBuilder = StringBuilderHelper.getStringBuilder();
						stringBuilderHelper.appendValue(stringBuilder,inputString);
						logger.log(Level.INFO,"The String Builder Length : "+stringBuilderHelper.stringBuilderLength(stringBuilder));
						logger.log(Level.INFO,"Enter the no of Strings");
						int noOfStrings  = scanner.nextInt();
						scanner.nextLine();
						String[] tempStringList = StringBuilderHelper.getStringArray(noOfStrings);
						logger.log(Level.INFO,"Enter "+noOfStrings+" number of Strings : ");
						for(int index=0;index<noOfStrings;index++){
							tempStringList[index] = scanner.nextLine();
						}
						logger.log(Level.INFO,"Enter the Delimiters to Append : ");
						String delimiters = scanner.nextLine();
						stringBuilder = stringBuilderHelper.joinDelimters(stringBuilder,tempStringList,delimiters);
						logger.log(Level.INFO,"The Resulted String Length:"+stringBuilderHelper.stringBuilderLength(stringBuilder));
						logger.log(Level.INFO,"The Resulted joined String :"+stringBuilderHelper.buildertoString(stringBuilder));
					}
					catch(InputMismatchException e){
						logger.log(Level.SEVERE,"Enter non Integer input!! Exception :");
						scanner.nextLine();
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,"Exception :"+e.getMessage(),e);
						if(e.getCause()!=null){
							logger.log(Level.SEVERE,"Caused By : "+e.getCause().getMessage());
						}
					}
					break;
				}
				case 3:{
					scanner.nextLine();
					logger.log(Level.INFO,"Enter the Two String to Append in StringBuilder : ");
					String stringOne = scanner.nextLine();
					String stringTwo = scanner.nextLine();
					try{
						StringBuilder stringBuilder = StringBuilderHelper.getStringBuilder();
						stringBuilderHelper.appendValue(stringBuilder,stringOne);
						logger.log(Level.INFO,"Enter the delimeters");
						String delimiters = scanner.nextLine();
						stringBuilderHelper.appendValue(stringBuilder,(delimiters+stringTwo));
						logger.log(Level.INFO,"The String Builder Length : "+stringBuilderHelper.stringBuilderLength(stringBuilder));
						logger.log(Level.INFO,"Enter the String to Append Inbetween:");
						String inputAppendString = scanner.nextLine();
						logger.log(Level.INFO,"The Resulted append String :"+stringBuilderHelper.appendBetween(stringBuilder,inputAppendString,delimiters));
						logger.log(Level.INFO,"The Resulted String Length:"+stringBuilderHelper.stringBuilderLength(stringBuilder));
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,"Exception : "+e.getMessage(),e);
					}
					break;
				}
				case 4:{
					scanner.nextLine();
					logger.log(Level.INFO,"Enter the Two String to Append in StringBuilder : ");
					String stringOne = scanner.nextLine();
					String stringTwo = scanner.nextLine();
					try{
						StringBuilder stringBuilder = StringBuilderHelper.getStringBuilder();
						stringBuilderHelper.appendValue(stringBuilder,stringOne);
						logger.log(Level.INFO,"Enter the delimeters");
						String delimiters = scanner.nextLine();
						stringBuilderHelper.appendValue(stringBuilder,(delimiters+stringTwo));
						logger.log(Level.INFO,"The String Builder Length : "+stringBuilderHelper.stringBuilderLength(stringBuilder));
						stringBuilder = stringBuilderHelper.deleteFirstString(stringBuilder,delimiters);
						logger.log(Level.INFO,"The Resulted deleted String :"+stringBuilderHelper.buildertoString(stringBuilder));
						logger.log(Level.INFO,"The Resulted String Length:"+stringBuilderHelper.stringBuilderLength(stringBuilder));
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,"Exception : "+e.getMessage(),e);
					}
					break;
				}
				case 5:{
					scanner.nextLine();
					logger.log(Level.INFO,"Enter the Three String to Append in StringBuilder : ");
					String stringOne = scanner.nextLine();
					String stringTwo = scanner.nextLine();
					String stringThree = scanner.nextLine();
					try{
						StringBuilder stringBuilder = StringBuilderHelper.getStringBuilder();
						stringBuilderHelper.appendValue(stringBuilder,stringOne);
						logger.log(Level.INFO,"Enter the delimeters to append");
						String oldDelimiters = scanner.nextLine();
						stringBuilderHelper.appendValue(stringBuilder,(oldDelimiters+stringTwo));
						stringBuilderHelper.appendValue(stringBuilder,(oldDelimiters+stringThree));
						logger.log(Level.INFO,"The String Builder Length : "+stringBuilderHelper.stringBuilderLength(stringBuilder));
						logger.log(Level.INFO,"Enter the new Delimiters to replace :");
						String newDelimiters = scanner.nextLine(); 
						stringBuilder = stringBuilderHelper.delimeterReplace(stringBuilder,oldDelimiters,newDelimiters);
						logger.log(Level.INFO,"The Resulted replaced String :"+stringBuilderHelper.buildertoString(stringBuilder));
						logger.log(Level.INFO,"The Resulted String Length:"+stringBuilderHelper.stringBuilderLength(stringBuilder));
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,"Exception : "+e.getMessage(),e);
					}
					break;
				}
				case 6:{
					scanner.nextLine();
					logger.log(Level.INFO,"Enter the Three String to Append in StringBuilder : ");
					String stringOne = scanner.nextLine();
					String stringTwo = scanner.nextLine();
					String stringThree = scanner.nextLine();
					try{
						StringBuilder stringBuilder = StringBuilderHelper.getStringBuilder();
						stringBuilderHelper.appendValue(stringBuilder,stringOne);
						logger.log(Level.INFO,"Enter the delimeters to append");
						String delimiters = scanner.nextLine();
						stringBuilderHelper.appendValue(stringBuilder,(delimiters+stringTwo));
						stringBuilderHelper.appendValue(stringBuilder,(delimiters+stringThree));
						logger.log(Level.INFO,"The String Builder Length : "+stringBuilderHelper.stringBuilderLength(stringBuilder));
						stringBuilder = stringBuilderHelper.stringReverse(stringBuilder);
						logger.log(Level.INFO,"The Resulted reverse String :"+stringBuilderHelper.buildertoString(stringBuilder));
						logger.log(Level.INFO,"The Resulted String Length:"+stringBuilderHelper.stringBuilderLength(stringBuilder));
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,"Exception : "+e.getMessage(),e);
					}
					break;
				}
				case 7:{
					scanner.nextLine();
					logger.log(Level.INFO,"Enter the String min(10 character) String to Append in StringBuilder : ");
					String stringOne = scanner.nextLine();
					try{
						StringBuilder stringBuilder = StringBuilderHelper.getStringBuilder();
						stringBuilderHelper.appendValue(stringBuilder,stringOne);
						logger.log(Level.INFO,"The String Builder Length : "+stringBuilderHelper.stringBuilderLength(stringBuilder));
						logger.log(Level.INFO,"Enter the Start index of substring :");
						int startIndex = scanner.nextInt();
						logger.log(Level.INFO,"Enter the End index of substring");
						int endIndex = scanner.nextInt();
						stringBuilder = stringBuilderHelper.deleteParticularSubstring(stringBuilder,startIndex,endIndex);
						logger.log(Level.INFO,"The Resulted deleted String :"+stringBuilderHelper.buildertoString(stringBuilder));
						logger.log(Level.INFO,"The Resulted String Length:"+stringBuilderHelper.stringBuilderLength(stringBuilder));
					}
					catch(InputMismatchException e){
						logger.log(Level.SEVERE,"InputMismatchException Occured : "+e.getMessage(),e);
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,"Exception : "+e.getMessage(),e);
					}
					break;	
				}
				case 8:{
					scanner.nextLine();
					logger.log(Level.INFO,"Enter the String min(10 character) to Append in StringBuilder : ");
					String stringOne = scanner.nextLine();
					try{
						StringBuilder stringBuilder = StringBuilderHelper.getStringBuilder();
						stringBuilderHelper.appendValue(stringBuilder,stringOne);
						logger.log(Level.INFO,"The String Builder Length : "+stringBuilderHelper.stringBuilderLength(stringBuilder));
						logger.log(Level.INFO,"Enter the Start index of substring :");
						int startIndex = scanner.nextInt();
						logger.log(Level.INFO,"Enter the End index of substring");
						int endIndex = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Replace subString : ");
						String replaceString = scanner.nextLine();
						stringBuilder = stringBuilderHelper.replaceParticularSubstring(stringBuilder,startIndex,endIndex,replaceString);
						logger.log(Level.INFO,"The Resulted reverse String :"+stringBuilderHelper.buildertoString(stringBuilder));
						logger.log(Level.INFO,"The Resulted String Length:"+stringBuilderHelper.stringBuilderLength(stringBuilder));
					}
					catch(InputMismatchException e){
						logger.log(Level.SEVERE,"InputMismatchException Occured : "+e.getMessage(),e);
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,"Exception : "+e.getMessage(),e);
					}
					break;
				}
				case 9:{
					scanner.nextLine();
					logger.log(Level.INFO,"Enter the Three String to Append in StringBuilder : ");
					String stringOne = scanner.nextLine();
					String stringTwo = scanner.nextLine();
					String stringThree = scanner.nextLine();
					try{
						StringBuilder stringBuilder = StringBuilderHelper.getStringBuilder();
						stringBuilderHelper.appendValue(stringBuilder,stringOne);
						logger.log(Level.INFO,"Enter the character to check :");
						String delimiters = scanner.nextLine();
						stringBuilderHelper.appendValue(stringBuilder,stringTwo);
						stringBuilderHelper.appendValue(stringBuilder,stringThree);
						logger.log(Level.INFO,"The Resulted String Length:"+stringBuilderHelper.stringBuilderLength(stringBuilder));
						int index = stringBuilderHelper.findFirstIndexOfDelimiters(stringBuilder,delimiters);
						if(index==-1){
							logger.log(Level.INFO,"Character not Occured in the StringBuilder");
						}
						else{
							logger.log(Level.INFO,"The First Occurenece index of delimiter : "+index);
						}					
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,"Exception : "+e.getMessage(),e);
					}
					break;
				}
				case 10:{
					scanner.nextLine();
					logger.log(Level.INFO,"Enter the Three String to Append in StringBuilder : ");
					String stringOne = scanner.nextLine();
					String stringTwo = scanner.nextLine();
					String stringThree = scanner.nextLine();
					try{
						StringBuilder stringBuilder = StringBuilderHelper.getStringBuilder();
						stringBuilderHelper.appendValue(stringBuilder,stringOne);
						logger.log(Level.INFO,"Enter the character to check :");
						String delimiters = scanner.nextLine();
						stringBuilderHelper.appendValue(stringBuilder,stringTwo);
						stringBuilderHelper.appendValue(stringBuilder,stringThree);
						logger.log(Level.INFO,"The Resulted String Length:"+stringBuilderHelper.stringBuilderLength(stringBuilder));
						int index = stringBuilderHelper.findLastIndexOfDelimiters(stringBuilder,delimiters);
						if(index==-1){
							logger.log(Level.INFO,"Character not Occured in the StringBuilder");
						}
						else{
							logger.log(Level.INFO,"The Last Occurenece index of delimiter : "+index);
						}
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,"Exception : "+e.getMessage(),e);
					}
					break;
				}
				case 11:{
					try{
						logger.log(Level.INFO,stringBuilderHelper.stringBuilderLength(null)+"");
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					try {
					   logger.log(Level.INFO,stringBuilderHelper.buildertoString(null));
					} catch (CustomException e) {
					   logger.log(Level.SEVERE,e.getMessage(),e);
					}
					try{
						logger.log(Level.INFO,stringBuilderHelper.buildertoString(null));
					} catch (CustomException e) {
					   logger.log(Level.SEVERE,e.getMessage(),e);
					}
					try {
					   logger.log(Level.INFO,stringBuilderHelper.appendValue(null,null).toString());
					} catch (CustomException e) {
					   logger.log(Level.SEVERE,e.getMessage(),e);
					}
					try {
					   logger.log(Level.INFO,stringBuilderHelper.joinDelimters(null,null,null).toString());
					} catch (CustomException e) {
					   logger.log(Level.SEVERE,e.getMessage(),e);
					}
					try {
					   logger.log(Level.INFO,stringBuilderHelper.appendBetween(null,null,null).toString());
					} catch (CustomException e) {
					   logger.log(Level.SEVERE,e.getMessage(),e);
					}
					try {
					   logger.log(Level.INFO,stringBuilderHelper.stringReverse(null).toString());		   
					} catch (CustomException e) {
					   logger.log(Level.SEVERE,e.getMessage(),e);
					}
					try {
					   logger.log(Level.INFO,stringBuilderHelper.deleteFirstString(null,null).toString());		   
					} catch (CustomException e) {
					   logger.log(Level.SEVERE,e.getMessage(),e);
					}
					try {
					   logger.log(Level.INFO,stringBuilderHelper.findLastIndexOfDelimiters(null,null)+"");		   
					} catch (CustomException e) {
					   logger.log(Level.SEVERE,e.getMessage(),e);
					}
					try {
					   logger.log(Level.INFO,stringBuilderHelper.findFirstIndexOfDelimiters(null,null)+"");		   
					} catch (CustomException e) {
					   logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				default : break;
			}
		}
		while(choice!=0);
		logger.log(Level.WARNING,"Exited Successfully !!!");
		scanner.close();
	}
	
	static void taskDisplay(){
		logger.log(Level.INFO,"***************Select the Operation in StringBuilder**************\n");
		logger.log(Level.INFO,"1. Enter String to check length before and after append.");
		logger.log(Level.INFO,"2. Enter String to check length and append before and again append n strings.");
		logger.log(Level.INFO,"3. Enter two string and add some delimiters inbetween add third string inbetween them");
		logger.log(Level.INFO,"4. Enter two Strings with a space in between & print the length of it.\n   Then delete the first String & print the length & the final String");
		logger.log(Level.INFO,"5. create a StringBuilder with 3 Strings with a space in between & print the length of it.\n   Then replace the space with “-” & print the length & the final String");
		logger.log(Level.INFO,"6. create a StringBuilder with 3 Strings with a space in between & print the length of it.\n   Then reverse the string & print the length & the final Strin");
		logger.log(Level.INFO,"7. create a StringBuilder with a String(minimum 10 chars) & print the length of it.\n   Then delete the characters from 6 to 8 index & print the length & the final String");
		logger.log(Level.INFO,"8. StringBuilder with a String(minimum 10 chars) & print the length of it.\n   Then replace the characters from 6 to 8 index with “XYZ” & print the length & the final String");
		logger.log(Level.INFO,"9. StringBuilder with 3 Strings with a “#” in between & print the length of it.\n   Then find the index of the first “#” in the StringBuilde");
		logger.log(Level.INFO,"10. TringBuilder with 3 Strings with a “#” in between & print the length of it.\n   Then find the index of the last “#” in the StringBuilder");
		logger.log(Level.INFO,"11. Testing...");
		logger.log(Level.INFO,"0. Enter Zero to Exit.\n");
	}
} 
