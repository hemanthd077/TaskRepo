package runner;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import birds.Duck;
import birds.ParrotMod;
import car.Swift;
import car.SCross;
import car.Xuv;
import commonChecker.CommonChecker;
import customException.CustomException;
import car.Car;
import helper.InheritanceHelper;
import java.util.InputMismatchException;

public class InheritanceRunner {
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
		do{
			taskDisplay();
			try{
				choice = scanner.nextInt();
				if(choice<0 || choice>8){
					throw new CustomException("Invalid input!! choice need to be between between 0 to 8.");
				}
			}
			catch(CustomException e){
				logger.log(Level.SEVERE,"Exception :"+e.getMessage(),e);
			}
			scanner.nextLine();
			switch(choice){
				case 1:{
					Swift swift = new Swift();
					  try{
					  	logger.log(Level.INFO,"Enter the Values of Swift");
					  	logger.log(Level.INFO,"Enter the No of Seats");
					  	swift.setSeats(scanner.nextInt());
					  	logger.log(Level.INFO,"Enter the No of Airbags");
					  	swift.setAirbags(scanner.nextInt());
					  	scanner.nextLine();
					  	logger.log(Level.INFO,"Enter the Model");
					  	swift.setModel(scanner.nextLine());
					  	logger.log(Level.INFO,"Enter the Color");
					  	swift.setColor(scanner.nextLine());

						logger.log(Level.INFO,"-----The value GetFrom getter of Swift");
						logger.log(Level.INFO,"No of Seats : "+swift.getSeats());
						logger.log(Level.INFO,"No of Airbags : "+swift.getAirbags());
						logger.log(Level.INFO,"Model : "+ swift.getModel());
						logger.log(Level.INFO,"Color : "+swift.getColor());
					}
					catch(InputMismatchException e){
						logger.log(Level.SEVERE,"InputMisMatchException Occured on Swift setter ",e);
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 2:{
					SCross sCross = new SCross();
				 	try{
				 		logger.log(Level.INFO,"Enter the Values of Swift");
					  	logger.log(Level.INFO,"Enter the No of Seats: ");
					  	sCross.setSeats(scanner.nextInt());
					  	logger.log(Level.INFO,"Enter the No of Airbags: ");
					  	sCross.setAirbags(scanner.nextInt());
					  	scanner.nextLine();
					  	logger.log(Level.INFO,"Enter the Model : ");
					  	sCross.setModel(scanner.nextLine());
					  	logger.log(Level.INFO,"Enter the Color : ");
					  	sCross.setColor(scanner.nextLine());
					  	logger.log(Level.INFO,"Enter the Year of Make : ");
					  	sCross.setYearOfMake(scanner.nextInt());
					  	scanner.nextLine();
					  	logger.log(Level.INFO,"Enter the Engine Number : ");
					  	sCross.setEngineNumber(scanner.nextLine());
					  	logger.log(Level.INFO,"Enter the Type of Car : ");
					  	sCross.setType(scanner.nextLine());
					  	
					  	logger.log(Level.INFO,"-----The value GetFrom getter of SCross");
						logger.log(Level.INFO,"No of Seats : "+sCross.getSeats());
						logger.log(Level.INFO,"No of Airbags : "+sCross.getAirbags());
						logger.log(Level.INFO,"Model : "+ sCross.getModel());
						logger.log(Level.INFO,"Color : "+sCross.getColor());
						logger.log(Level.INFO,"Year of Make : "+sCross.getYearOfMake());
						logger.log(Level.INFO,"Engine Number : "+sCross.getEngineNumber());
						logger.log(Level.INFO,"Type of Car : "+sCross.getType());
					}
					catch(InputMismatchException e){
						logger.log(Level.SEVERE,"InputMisMatchException Occured on SCross Setter",e);
						scanner.nextLine();
					}
					catch(CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 3:{
					Xuv xuv = new Xuv();
					logger.log(Level.INFO,"---Trying to invoke Car---");
					SCross sCross = new SCross();
					Swift swift = new Swift();
					try{
						logger.log(Level.INFO,"Passing XUV Object : " +  InheritanceHelper.invokeMethod(xuv,"SUV"));
						logger.log(Level.INFO,"Passing SCross Object : "+InheritanceHelper.invokeMethod(sCross,"Sedan"));
						logger.log(Level.INFO,"Passing Swift Object : "+InheritanceHelper.invokeMethod(swift,"Hatch"));
					}
					catch (CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
					break;
				}
				case 4:{
					logger.log(Level.INFO,"---Accept Swift object as argument---");

					try {
						Swift objSwift = new Swift();
						logger.log(Level.INFO,"Swift Object is Passed" + InheritanceHelper.swiftInvokeMethod(objSwift));
					}
					catch (CustomException e){
						logger.log(Level.SEVERE,e.getMessage(),e);
					}
				//    --------------notPossible-------------
				//    Car objectCarSwift = new Swift();
				//    helper.swiftInvokeMethod(objectCarSwift);

				//    Xuv objectXuv = new Xuv();
				//    helper.swiftInvokeMethod(objectXuv);

				//    SCross objectScross = new SCross();
				//    helper.swiftInvokeMethod(objectScross);
				//    ---------------------------------------
					break;
				}
				case 5:{
					SCross sCrossObject = new SCross();
					logger.log(Level.INFO,"Calling Scross Variable maintenance method with scross object : "+ sCrossObject.maintenance());
				
					Car carSwiftObject = new SCross();
					logger.log(Level.INFO,"Calling Car Variable maintenance method with Scross object : "+ carSwiftObject.maintenance());
					
					Car carObject = new Car();
					logger.log(Level.INFO,"Calling car Variable maintenance method with car object : "+ carObject.maintenance());
					
					Swift swiftObject = new Swift();
					logger.log(Level.INFO,"Calling Swift Variable maintenance method with swift object : "+ swiftObject.maintenance());      
					break;
				}
				case 6:{
						@SuppressWarnings("unused")	
						Xuv obj = new Xuv();
						@SuppressWarnings("unused")
						Xuv XuvOverloadObject = new Xuv("Calling overloaded constructor from Runner");
						break;
				}
				case 7:{
				//	BirdAbstract birdAbstract = new BirdAbstract();
				//	abstract class can't instanced
					
					ParrotMod parrotMod = new ParrotMod();
					logger.log(Level.INFO,"Calling fly of abstract class : "+parrotMod.fly());
					logger.log(Level.INFO,"Calling speak method of abstract Class : "+parrotMod.speak());
					break;
				}
				case 8:{
					 Duck duck = new Duck();
					 logger.log(Level.INFO,"Calling the duck overrider method : "+ duck.fly());
					 logger.log(Level.INFO,"Calling the speak method of abstract class : "+duck.speak());
					break;
				}
				default: break;
			}
		}
		while(choice!=0);
		logger.log(Level.WARNING,"Exited Successfully");
		scanner.close();
    }
    
    static void taskDisplay(){
    		logger.log(Level.INFO,"\n----------------Select the Choice----------------\n");
    		logger.log(Level.INFO,"1. Create an instance for Swift. Using that, call all the setter methods &\n   then all the getter methods in Swift class alone.\n   Print the values returned from the getter methods");
    		logger.log(Level.INFO,"2. Create an instance for SCross. Using that, call all the setter \n   methods & then all the getter methods in SCross including superclass methods.\n   Print the values returned from the getter methods");
    		logger.log(Level.INFO,"3. The actual underlying object of the incoming Car object.\n   If the incoming object is Swift print “Hatch'', if XUV print SUV & if SCross print Sedan.");
    		logger.log(Level.INFO,"4. Try to invoke that method with objects of XUV, SCross & understand how different this scenario is from the 4th task.");
    		logger.log(Level.INFO,"5. Class create another method which accepts a Swift object as anargument.");
    		logger.log(Level.INFO,"6. The Car class create an overloaded constructor which accepts a String & print the incoming \n   String. In the XUV class’s default constructor,\n   try to call the overloaded Constructor of the super class.");
    		logger.log(Level.INFO,"7. Create an abstract class BirdAbstract with two methods: fly() & speak(). Both the fly()\n   & speak() can print a statement & these methods need not be abstract");
    		logger.log(Level.INFO,"8. Create a class Bird with two methods: fly() & speak().\n   Let the fly() method alone be abstract.\n   Now create a subclass Duck extending Bird & provide implementation for the fly.");
    		logger.log(Level.INFO,"0. Exit\n");
    }
}
