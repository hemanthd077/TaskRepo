package runner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import commonChecker.CommonChecker;
import customException.CustomException;
import date.DateOperation;
import enumFiles.GetString;
import enumFiles.colors;
import helper.ArrayListHelper;
import helper.BasicProgrammingHelper;
import helper.PropertyHelper;
import newString.MyCustomString;
import pojo.SampleClassOne;
import singleTon.GetNumber;

public class BasicProgrammingRunner {
	private static Logger logger = Logger.getGlobal();
	public static void main(String... args) throws CustomException {
		
		
		CommonChecker.loggerHandler("LogRecord");
		
		logger.setLevel(Level.ALL);
		

		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			fileMenu();
			try {
				choice = scanner.nextInt();
				if(choice>10 || choice<0) {
					throw new CustomException("Ente the Number Greater than 0 and Lesser than 10");
				}
			}
			catch(InputMismatchException e) {
				logger.log(Level.SEVERE,"Enter Integer not String");
				scanner.nextLine();
			}
			catch(CustomException e) {
				logger.log(Level.SEVERE,e.getMessage());
			}
			
			BasicProgrammingHelper helper = new BasicProgrammingHelper();
			ArrayListHelper arrayHelper = new ArrayListHelper();
			switch(choice) {
				case 1:{
					try {
						List<String> list = arrayHelper.getArrayList();
						logger.log(Level.INFO,"Enter the no of strings to add to file");
						int n = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings:");
						for(int i=0;i<n;i++) {
							list.add(scanner.nextLine());
						}
						
						logger.log(Level.INFO,"Enter the FileName : ");
						String fileName = scanner.nextLine();
						logger.log(Level.INFO,"Enter the Path of the file Creation");
						String filePath = scanner.nextLine();
						if(helper.createFile(list,fileName,filePath)) {
							logger.log(Level.INFO,"Successfully file Created");
						}
						else {
							logger.log(Level.INFO,"Error in file Creation");
						}		
						
//						fileRead
//						 logger.log(Level.INFO,"Enter the FileName to read: ");
//						String fileNameRead = scanner.nextLine();
//						 logger.log(Level.INFO,"Enter the Path of the file Creation");
//						String filePathRead = scanner.nextLine();
//						List<String> resultList = helper.readFile(fileNameRead, filePathRead);
//						for(String i : resultList) {
//							 logger.log(Level.INFO,i);
//						}
					}
					catch(InputMismatchException e) {
						logger.log(Level.SEVERE,"Enter Integer not String",e);
						scanner.nextLine();
					}
					catch(CustomException e) {
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 2:{
					try {
						PropertyHelper properties = new PropertyHelper();
						logger.log(Level.INFO,"Enter no of Strings");
						int noOfStrings = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfStrings;i++) {
							properties.setProperties(i+"",scanner.nextLine());
						}
						
						logger.log(Level.INFO,"Enter the FileName : ");
						String fileName = scanner.nextLine();
						logger.log(Level.INFO,"Enter the Path of the file Creation");
						String filePath = scanner.nextLine();
						if(properties.propertiesFileCreation(fileName, filePath)) {
							logger.log(Level.INFO,"File upload Successfull!!");
						}
						else {
							logger.log(Level.INFO,"File Upload Failed");
						}
					}
					catch(InputMismatchException e) {
						logger.log(Level.SEVERE,"Enter Integer not String",e);
						scanner.nextLine();
					}
					catch(CustomException e) {
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
				}
				case 3:{ 
					try {
						scanner.nextLine();
						PropertyHelper properties = new PropertyHelper();
						logger.log(Level.INFO,"---Read the data from Properties---");
						logger.log(Level.INFO,"Enter File name:");
						String fileName = scanner.nextLine();
						logger.log(Level.INFO,"Enter the Path of the file");
						String filePath = scanner.nextLine();
						properties.propertiesFileReadandLoad(fileName, filePath);
						displayProperties(properties.getProperties());
					}
					catch(InputMismatchException e) {
						logger.log(Level.SEVERE,"Enter Integer not String",e);
						scanner.nextLine();
					}
					catch(CustomException e) {
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 4:{
					scanner.nextLine();
					logger.log(Level.INFO,"Enter the String to Call Constructer:");
					String inputString = scanner.nextLine();
					MyCustomString myCustomString = new MyCustomString(inputString);
					logger.log(Level.INFO,myCustomString.toString());
					break;
				}
				case 5:{
					try {
						logger.log(Level.INFO,"Enter the Integer to Store in Pojo class");
						int inputInteger = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the String to store in Pojo Class");
						String inputString = scanner.nextLine();
						SampleClassOne pojoClassOne = new SampleClassOne(inputInteger, inputString);
						logger.log(Level.INFO,"The Object data : inputNumber = "+pojoClassOne);
					}
					catch(InputMismatchException e) {
						logger.log(Level.INFO,"Input Mis Match Exception Occured",e);
						scanner.nextLine();
					}
					break;
				}
				case 6:{
					try {
						SampleClassOne pojoClassOne = new SampleClassOne();
						logger.log(Level.INFO,"Enter the Integer to Store in Pojo class");
						int inputInteger = scanner.nextInt();
						pojoClassOne.setInputNumber(inputInteger);
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the String to store in Pojo Class");
						String inputString = scanner.nextLine();
						pojoClassOne.setInputString(inputString);
						
						logger.log(Level.INFO,"The Object data : inputNumber = "+ pojoClassOne);
					}
					catch(InputMismatchException e) {
						logger.log(Level.SEVERE,"Input Mis Match Exception Occured",e);
					}
				}
				case 7:{
					try {
						
						Class<?> sampleClassOne = Class.forName("pojo.SampleClassOne");
						Object obj = sampleClassOne.getConstructor().newInstance();
						
						Method[] method = obj.getClass().getDeclaredMethods();
						
						for(Method m : method) {
							logger.log(Level.SEVERE,"M : "+m.getName());
						}
						
						logger.log(Level.INFO,"Enter the Integer : ");
						int inputInteger = scanner.nextInt();
						
						scanner.nextLine();
						
						logger.log(Level.INFO,"Enter the String to store in Pojo Class");
						String inputString = scanner.nextLine();
						Constructor<?> constructor = sampleClassOne.getConstructor(int.class,String.class);
						Object obj1 = constructor.newInstance(inputInteger,inputString);
			
						Method toString = sampleClassOne.getDeclaredMethod("toString");
						logger.log(Level.INFO,toString.invoke(obj1).toString());
						
						logger.log(Level.INFO,"One setter Method");
						logger.log(Level.INFO,"Enter the number to set :");
						int newNum = scanner.nextInt();
						
						logger.log(Level.INFO,"One getter Method");
						Method getInputNumber = sampleClassOne.getDeclaredMethod("getInputNumber");
						logger.log(Level.INFO,"Integer before: "+getInputNumber.invoke(obj1));
						Method setInputNumber = sampleClassOne.getDeclaredMethod("setInputNumber",int.class);
						setInputNumber.invoke(obj1,newNum);
						logger.log(Level.INFO,"Integer after: "+getInputNumber.invoke(obj1));	
						
					}
					catch(Exception e) {
						logger.log(Level.SEVERE,"Exception Occured"+ e.getLocalizedMessage(),e);
					}
					break;
				}
				case 8:{
					logger.log(Level.INFO,"Enum Operation");
					logger.log(Level.INFO,"Enter the code of the color");
					for(colors a : colors.values()) {
						logger.log(Level.INFO,"Color code of "+a+" is "+a.getCode());
					}
					break;
				}
				case 9:{
					logger.log(Level.INFO,"--Single Tone Class--");
					GetNumber obj1 = GetNumber.getInstance();
					@SuppressWarnings("unused")
					GetNumber obj2 = GetNumber.getInstance();
					obj1.setNumber(10);
					logger.log(Level.INFO,obj1.getNumber()+"");
					obj1.setNumber(20);
					logger.log(Level.INFO,obj1.getNumber()+"");
					
					GetString getString = GetString.INSTANCE;
					getString.setName("ZOHO");
					logger.log(Level.INFO,getString.getName());
					
					break;
				}
				case 10:{
					try {
						DateOperation date = new DateOperation();
						logger.log(Level.INFO,"--Date Operation--");
						logger.log(Level.INFO,"\nCurrent Date and Time : "+ date.getCurrentTime());
						logger.log(Level.INFO,"currentTime in milliseconds : "+ date.currentTimeMillis());
					
						ArrayList<String> idArrayList = date.getZoneIds();
						
						for(int i=0;i<idArrayList.size();i++) {
							logger.log(Level.INFO,(i+1)+" : "+idArrayList.get(i)+"\n");
						}
						
						logger.log(Level.INFO,"Choose the Zone1 from above");
						int temp1 = scanner.nextInt();
						String location1 = idArrayList.get(temp1+1);
						logger.log(Level.INFO,"Choose the Zone2 from above");
						int temp2 = scanner.nextInt();
						String location2 = idArrayList.get(temp2+1);
					
					    ZonedDateTime resultLocation1 =  date.getCurrentTimeSpecificLoc(location1);
					    logger.log(Level.INFO,"\n"+idArrayList.get(temp1)+": "+ formatTime(resultLocation1));
					    ZonedDateTime resultLocation2 = date.getCurrentTimeSpecificLoc(location2);
					    logger.log(Level.INFO,idArrayList.get(temp2)+" : "+ formatTime(resultLocation2));
					    
					    logger.log(Level.INFO,"\nThe day of the millisecond : "+date.getDay(date.currentTimeMillis(),"Asia/Calcutta"));
					    logger.log(Level.INFO,"The Month of the millisecond : "+date.getMonth(date.currentTimeMillis(),"Asia/Calcutta"));
					    logger.log(Level.INFO,"The Year of the millisecond : "+date.getYear(date.currentTimeMillis(),"Asia/Calcutta"));
					}
					catch(CustomException e) {
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				default:break;
			}
		} while (choice!=0);
		
		logger.log(Level.WARNING,"Exited Successfully");
		
		scanner.close();
	}
	
	static void fileMenu() {
		logger.log(Level.INFO,"\n==== select the File Operation ====\n");
		 logger.log(Level.INFO,"1. Generate a file as sample.txt and add three lines");
		 logger.log(Level.INFO,"2. Create util.Properties and add file");
		 logger.log(Level.INFO,"3. From above generated file by properties load and print that");
		 logger.log(Level.INFO,"4. Create tostring method and override in some class with some constrains");
		 logger.log(Level.INFO,"5. Create Pojo class and add value by calling custom default Constructor");
		 logger.log(Level.INFO,"6. Create Pojo class and add value by calling default Constructor");
		 logger.log(Level.INFO,"7. Create pojo class with string and integer and use Reflection to access");
		 logger.log(Level.INFO,"8. Create Enum for Rainbow with code respectively.");
		 logger.log(Level.INFO,"9. Create a SingleTone Class.");
		 logger.log(Level.INFO,"10. Time Operations");
		 logger.log(Level.INFO,"0. Exit");
	}
	
	static void displayProperties(Properties properties){
		 logger.log(Level.INFO,properties.toString());
	}
	
	static String formatTime(ZonedDateTime time) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss");
	    return time.format(formatter);
	}
}
