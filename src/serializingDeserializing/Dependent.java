package serializingDeserializing;

import java.io.Serializable;

public class Dependent implements Serializable{
	private static final long serialVersionUID = 1L;
	private int dependentId;
	private String dependentName;
	private int dependentAge;
	private String dependentRelationship;
	private String dependentEmployee_id;
	
	public int getDependentId() {
		return dependentId;
	}
	
	public String getDependentName() {
		return dependentName;
	}
	
	public int getDependentAge() {
		return dependentAge;
	}
	
	public String getDependentRelationship() {
		return dependentRelationship;
	}
	
	public String getDependentEmployee_id() {
		return dependentEmployee_id;
	}
	
	public void setDependentId(int dependentId) {
		this.dependentId = dependentId;
	}
	
	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}
	
	public void setDependentAge(int dependentAge) {
		this.dependentAge = dependentAge;
	}
	
	public void setDependentRelationship(String dependentRelationship) {
		this.dependentRelationship = dependentRelationship;
	}
	
	public void setDependentEmployee_id(String dependentEmployee_id) {
		this.dependentEmployee_id = dependentEmployee_id;
	}
	
	
}

