package car;

import commonChecker.CommonChecker;
import customException.CustomException;

public class Swift extends Car {
	private int seats;
	private int airbags;
	private String model;
	private String color;

	public Swift(){
		super();
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getAirbags() {
		return airbags;
	}

	public void setAirbags(int airbags) {
		this.airbags = airbags;
	}

	public String getModel() {
      	return model;
	}

	public void setModel(String model) throws CustomException{
	  	CommonChecker.checkNull(model);
	      this.model = model;
	}

	public String getColor() {
	      return color;
	}

	public void setColor(String color)  throws CustomException{
	  	CommonChecker.checkNull(color);
	      this.color = color;
	}
}
