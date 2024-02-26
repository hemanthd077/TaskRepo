package singleTon;

import java.io.Serializable;

public class GetNumber implements Serializable{
	
	private static final long serialVersionUID = 54321;
	private static volatile GetNumber obj;
	private int number;
	
	private Object readResolve() {
		return obj;
	}
	
	private GetNumber(){
		System.out.println("Instance Created For GetNumber");
	}

	public static GetNumber getInstance() {
		if(obj == null) {
			synchronized (GetNumber.class) {
				if(obj == null) {
					obj = new GetNumber();
				}
			}
		}
		return obj;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
