package pojo;

public class SampleClassOne {
	private int inputNumber;
	private String inputString;
	
	public SampleClassOne(int inputNumber, String inputString) {
		this.inputNumber = inputNumber;
		this.inputString = inputString;
	}

	public SampleClassOne() {	}

	@Override
	public String toString() {
		return  "[inputNumber = " + inputNumber + ", inputString = " + inputString + "]";
	}

	public int getInputNumber() {
		return inputNumber;
	}
	
	public String getInputString() {
		return inputString;
	}
	
	public void setInputNumber(int inputNumber) {
		this.inputNumber = inputNumber;
	}
	
	public void setInputString(String inputString) {
		this.inputString = inputString;
	}
}
