package car;

import commonChecker.CommonChecker;
import customException.CustomException;

public class Car {
	private int yearOfMake;
	private String engineNumber;
	private String type;

	public Car(int yearOfMake, String engineNumber, String type) {
  	this.yearOfMake = yearOfMake;
    	this.engineNumber = engineNumber;
    	this.type = type;
	}

	public int getYearOfMake() {
		return yearOfMake;
	}

	public void setYearOfMake(int yearOfMake) {
		this.yearOfMake = yearOfMake;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) throws CustomException {
		CommonChecker.checkNull(engineNumber);
    	this.engineNumber = engineNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) throws CustomException{
		CommonChecker.checkNull(type);
		this.type = type;
	}

	public Car(){
		System.out.println("Car default constructor");
	}
	
	public Car(String inputString){
		System.out.println("Input String : "+inputString);
	}

	public String maintenance(){
		return "Car under maintenance";
	}
}
