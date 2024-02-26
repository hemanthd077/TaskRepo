package newString;

public class MyCustomString {

	String inputString;
	
	public MyCustomString() {
		
	}
	
	public MyCustomString(String inputString) {
		this.inputString = inputString;
	}
	
	public String getInputString() {
		return inputString;
	}

	@Override
	public String toString() {
		return inputString;
	}
}
