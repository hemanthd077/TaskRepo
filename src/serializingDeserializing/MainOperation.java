package serializingDeserializing;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import commonChecker.CommonChecker;
import customException.CustomException;
import singleTon.GetNumber;

public class MainOperation {
	static Logger logger = Logger.getGlobal();
	@SuppressWarnings("static-access")
	public static void main(String... args) {
		try {
			CommonChecker.loggerHandler("LogRecord");
		} catch (CustomException e) {
			e.printStackTrace();
		}
		logger.setLevel(Level.ALL);
		
		TaskHelper taskHelper = new TaskHelper();
		
		Scanner scanner = new Scanner(System.in);
		try {
			int choice=0;
			do {
					operationMenu();
					choice = scanner.nextInt();
					switch(choice) {
						case 1:{
							Employee obj = new Employee();
							obj.setEmployeeId(1);
							obj.setEmployeeEmail("hemanth@gmail.com");
							obj.setEmployeeMobileNo(9876543210l);
							obj.setEmployeeDepartment("Zoho One");

							List<Dependent> dependentList = new ArrayList<>();
							
							Dependent dependentObj1 = new Dependent();
							dependentObj1.setDependentId(1);
							dependentObj1.setDependentAge(20);
							dependentObj1.setDependentName("Surya");
							dependentObj1.setDependentRelationship("Buddy");
							dependentList.add(dependentObj1);
							
							Dependent dependentObj2 = new Dependent();
							dependentObj2.setDependentId(2);
							dependentObj2.setDependentAge(21);
							dependentObj2.setDependentName("Ajit");
							dependentObj2.setDependentRelationship("Friend");
							dependentList.add(dependentObj2);
							
							obj.setDependent(dependentList);
							
							System.out.println("Hash code before :"+obj.hashCode());
							taskHelper.serializingObject(obj,"Employee.ser");
							
							Employee temp = taskHelper.deserializingObject("Employee.ser");
							
							System.out.println("Hash code after :"+temp.hashCode());
							System.out.println("serialVersionUID : "+temp.serialVersionUID);
							
							logger.log(Level.INFO,"Employee ID : "+temp.getEmployeeId());
							logger.log(Level.INFO,"Employee Dept : "+temp.getEmployeeName());
							logger.log(Level.INFO,"Employee Mobile no : "+temp.getEmployeeMobileNo());
							
							List<Dependent> resultDependent = temp.getDependent();
							
							for(Dependent tempDependent : resultDependent) {
						        logger.log(Level.INFO, "DEPENDENT_ID : " + tempDependent.getDependentId()
						                + "    DEPENDENT_NAME : " + tempDependent.getDependentName()
						                + "    DEPENDENT_AGE : " + tempDependent.getDependentAge()
						                + "    DEPENDENT_RELATIONSHIP : " + tempDependent.getDependentRelationship());
						    }
							
							break;
						}
						
						case 2:{
//							List<Employee> employeesList = new ArrayList<>();
//							Employee obj1 = new Employee();
//							obj1.setEmployeeId(1);
//							obj1.setEmployeeEmail("hemanth@gmail.com");
//							obj1.setEmployeeMobileNo(7876543211l);
//							obj1.setEmployeeDepartment("Zoho One");
//							employeesList.add(obj1);
//							
//							Employee obj2 = new Employee();
//							obj2.setEmployeeId(1);
//							obj2.setEmployeeEmail("surya@gmail.com");
//							obj2.setEmployeeMobileNo(8876543212l);
//							obj2.setEmployeeDepartment("TCS");
//							employeesList.add(obj2);
//							
//							Employee obj3 = new Employee();
//							obj3.setEmployeeId(1);
//							obj3.setEmployeeEmail("ajit@gmail.com");
//							obj3.setEmployeeMobileNo(6876543250l);
//							obj3.setEmployeeDepartment("TESLA");
//							employeesList.add(obj3);
							
							GetNumber getNum = GetNumber.getInstance();
							
							System.out.println("Hash code before :"+getNum.hashCode());
							taskHelper.serializingObject(getNum,"serialize.ser");
							
							Object temp = taskHelper.deserializingObject("serialize.ser");
							
							System.out.println("Hash code before :"+temp.hashCode());
							
							System.out.println(temp.getClass().getName());
							
							
						}
						default:break;
					}
			}
			while(choice>0 && choice<12);
		}
		catch(InputMismatchException e) {
			logger.log(Level.SEVERE,"Input mis match entred : ",e);
			scanner.nextLine();
		}
		catch(CustomException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,e.getMessage(),e.getCause());
		}
		logger.log(Level.WARNING,"Exited successfully");
		scanner.close();
	}
	
	
	private static void operationMenu() {
		logger.info("======== Serializing and Deserializong ========");
		logger.info("1.Adding one object to ser and read that");
		logger.info("");
		logger.info("0.exit");
	}
}
