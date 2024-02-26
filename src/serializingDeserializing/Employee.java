package serializingDeserializing;
import java.io.Serializable;
import java.util.List;


public class Employee implements Serializable{
	static final long serialVersionUID = 321987;
	private int employeeId;
	private String employeeName;
	private Long employeeMobileNo;
	private String employeeEmail;
	private String employeeDepartment;
	private List<Dependent> dependent;
	

	public List<Dependent> getDependent() {
		return dependent;
	}

	public void setDependent(List<Dependent> dependent) {
		this.dependent = dependent;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public Long getEmployeeMobileNo() {
		return employeeMobileNo;
	}
	
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public void setEmployeeMobileNo(Long employeeMobileNo) {
		this.employeeMobileNo = employeeMobileNo;
	}
	
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	
	@Override
	public String toString() {
		return "\nEmployeeId = " + employeeId
				+ "\nEmployeeName=" + employeeName 
				+ "\nEmployeeMobileNo = "+ employeeMobileNo
				+ "\nEmployeeEmail = " + employeeEmail 
				+ "\nEmployeeDepartment = " + employeeDepartment;
	}
}

