package jdbc;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import commonChecker.CommonChecker;
import customException.CustomException;
import database.ConnectionCreation;


public class JdbcRunner {
	
	static Logger logger = Logger.getGlobal();
	
	public static void main(String... args) {
		
		try {
			CommonChecker.loggerHandler("LogRecord");
		} catch (CustomException e) {
			e.printStackTrace();
		}
		logger.setLevel(Level.ALL);
		
		Scanner scanner = new Scanner(System.in);		
		JdbcHelper helper = new JdbcHelper();
		try {
			int choice=0;
			do {
					displaySqlOperation();
					choice = scanner.nextInt();
					switch(choice) {
						case 1:{
							if(helper.createTableEmployee()) {
								logger.log(Level.INFO,"Table Created Successfully");
							}
							else {
								logger.log(Level.INFO,"Failed to create table or table already exist");
							}
							break;
						}
						case 2:{
							logger.log(Level.INFO,"Enter the No of employee to Add :");
							int n = scanner.nextInt();
							scanner.nextLine();
							List<Employee> list = new ArrayList<>();
							for(int i=0;i<n;i++) {
								Employee obj = new Employee();
								logger.log(Level.INFO,"Enter the data to fill the employee data");
								logger.log(Level.INFO,"Enter the Name of the Employee");
								obj.setEmployeeName(scanner.nextLine());
								
								logger.log(Level.INFO,"Enter the mobile no of the Employee");
								obj.setEmployeeMobileNo(scanner.nextLong());
								scanner.nextLine();
								
								logger.log(Level.INFO,"Enter the Emailid of the Employee");
								obj.setEmployeeEmail(scanner.nextLine());
								
								logger.log(Level.INFO,"Enter the department of the Employee");
								obj.setEmployeeDepartment(scanner.nextLine());
								list.add(obj);
							}
							if(helper.insertValueEmployee(list)) {
								logger.info("Values of Employee Added successfully");
							}
							else {
								logger.warning("Values of Employee failed to add");
							}
							break;
						}
						case 3:{
							scanner.nextLine();
							logger.log(Level.INFO,"Enter the Employe name to retrive data");
							String name = scanner.nextLine();
							List<Employee> list = helper.getEmployeeData(name);
							int listSize = list.size();
							if(listSize!=0) {
								for(int i=0;i<listSize;i++) {
									logger.log(Level.INFO,list.get(i).toString());
								}
							}
							else {
								logger.log(Level.INFO,"No result Found");
							}
							break;
						}
						case 4:{
							scanner.nextLine();
							logger.log(Level.INFO,"Enter the employeeid :");
							int employeeId = scanner.nextInt();
							logger.log(Level.INFO,"Enter the field Name");
							String fieldName = scanner.nextLine();
							logger.log(Level.INFO,"Enter the Value to change");
							String changeValue = scanner.nextLine();
							if(helper.updateRecord(changeValue, fieldName, employeeId)) {
								logger.log(Level.INFO,"Updated in the record Successfully");
							}
							else {
								logger.log(Level.INFO,"Update failed or not record found");
							}
							break;
						}
						case 5:{
							logger.log(Level.INFO,"Enter the N to get Nresult");
							int n = scanner.nextInt();
							List<Employee> list = helper.getFirstN(n);
							int listSize = list.size();
							if(listSize!=0) {
								for(int i=0;i<listSize;i++) {
									logger.log(Level.INFO,list.get(i).toString());
								}
							}
							else {
								logger.log(Level.INFO,"No result Found");
							}
							break;
						}
						case 6 :{
							logger.log(Level.INFO,"Enter the N to get Nresult");
							int n = scanner.nextInt();
							List<Employee> list = helper.getBySorted(n,-1,"name");
							int listSize = list.size();
							if(listSize!=0) {
								for(int i=0;i<listSize;i++) {
									logger.log(Level.INFO,list.get(i).toString());
								}
							}
							else {
								logger.log(Level.INFO,"No result Found");
							}
							break;
						}
						case 7:{
							scanner.nextLine();
							logger.log(Level.INFO,"Enter the employeeid :");
							int employeeId = scanner.nextInt();
							if(helper.deleteRecord(employeeId)) {
								logger.log(Level.INFO,"deleted in the record Successfully");
							}
							else {
								logger.log(Level.INFO,"deletion failed or not record found");
							}
							break;
						}
						case 8:{
							logger.log(Level.INFO,"Creating Dependent table");
							if(helper.createTableDependent()){
								logger.log(Level.INFO,"Created Successfully");
							}
							else {
								logger.log(Level.INFO,"Creation failed");
							}
							break;
						}
						case 9:{
							logger.log(Level.INFO,"Enter the No of Dependent to Add :");
							int n = scanner.nextInt();
							scanner.nextLine();
							List<Dependent> list = new ArrayList<>();
							logger.log(Level.INFO,"Enter the data to fill the Dependent data");
							for(int i=0;i<n;i++) {
								Dependent obj = new Dependent();
								logger.log(Level.INFO,"Enter the Name of the Dependent");
								obj.setDependentName(scanner.nextLine());
								
								logger.log(Level.INFO,"Enter the age of the Dependent");
								obj.setDependentAge(scanner.nextInt());
								scanner.nextLine();
								
								logger.log(Level.INFO,"Enter the Relationship of the Dependent");
								obj.setDependentRelationship(scanner.nextLine());
								
								logger.log(Level.INFO,"Enter the Employee id");
								obj.setDependentEmployee_id(scanner.nextLine());
								list.add(obj);
							}
							if(helper.insertValueDependent(list)) {
								logger.info("Values of Dependent Added successfully");
							}
							else {
								logger.warning("Values of Dependent failed to add");
							}
							break;
						}
						case 10:{
							scanner.nextLine();
							logger.log(Level.INFO,"Enter the Employee id");
							int employeeID = scanner.nextInt();
							Map<Integer,Employee> employeeList =  helper.getEmployeeFullData(employeeID);
						    Integer employeeId = employeeID;
						    Employee employee = employeeList.get(employeeID);

						    logger.log(Level.INFO, "\nEMPLOYEE_ID : " + employeeId);
						    logger.log(Level.INFO, "EMPLOYEE_NAME : " + employee.getEmployeeName());

						    List<Dependent> dependents = employee.getDependent();
						    for (Dependent tempDependent : dependents) {
						        logger.log(Level.INFO, "DEPENDENT_ID : " + tempDependent.getDependentId()
						                + "    DEPENDENT_NAME : " + tempDependent.getDependentName()
						                + "    DEPENDENT_AGE : " + tempDependent.getDependentAge()
						                + "    DEPENDENT_RELATIONSHIP : " + tempDependent.getDependentRelationship());
						    }

						    logger.log(Level.INFO, "--------------------------------------------------\n");
							break;
						}
						case 11:{
							logger.log(Level.INFO,"Enter the N to get Nresult");
							int n = scanner.nextInt();
							Map<Integer,Employee> employeeList = helper.getEmployeeFirstN(n);
							for (Map.Entry<Integer, Employee> entry : employeeList.entrySet()) {
							    Integer employeeId = entry.getKey();
							    Employee employee = entry.getValue();

							    logger.log(Level.INFO, "\nEMPLOYEE_ID : " + employeeId);
							    logger.log(Level.INFO, "EMPLOYEE_NAME : " + employee.getEmployeeName());

							    List<Dependent> dependents = employee.getDependent();
							    for (Dependent tempDependent : dependents) {
							        logger.log(Level.INFO, "DEPENDENT_ID : " + tempDependent.getDependentId()
							                + "    DEPENDENT_NAME : " + tempDependent.getDependentName()
							                + "    DEPENDENT_AGE : " + tempDependent.getDependentAge()
							                + "    DEPENDENT_RELATIONSHIP : " + tempDependent.getDependentRelationship());
							    }

							    logger.log(Level.INFO, "--------------------------------------------------");
							}

							break;
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
			logger.log(Level.SEVERE,e.getMessage());
		}
		ConnectionCreation.closeConnection();
		logger.log(Level.WARNING,"Exited successfully");
		scanner.close();
	}
	
	static void displaySqlOperation() {
		logger.info("===== select JDBC Operation =====");
		logger.info("1. Create the Employee table programmatically with the columns viz.\n"
				+ "	EMPLOYEE_ID, NAME, MOBILE, EMAIL, DEPARTMENT by connecting to the\n"
				+ "	incubationDB instance in your MySQL server. Decide about the Primary Key before\n"
				+ "	creating the table.");
		logger.info("2. Get the details of employees from the commandLine & add those records into the\n"
				+ "	Employee table programmatically. Add up to 10 employees records.");
		logger.info("3. For a given employee name , retrieve the matching employee details from the\n"
				+ "	Employee table.");
		logger.info("4. Modify the Department or Mobile or Email of an employee by getting the updated\n"
				+ "	details from the commandLine.");
		logger.info("5. Print the first N employees' data in the commandLine.");
		logger.info("6. Print the first N employees' data in the commandLine sorted by name(any columns)\n"
				+ "	in descending order(may be ascending)");
		logger.info("7. Delete an employee by providing an Employee ID. Repeat 5th once again.");
		logger.info("8. Create a dependent table for the employees with columns viz. NAME, AGE,\n"
				+ "	RELATIONSHIP. Analyze how to relate this table data to the Employee table. If\n"
				+ "	needed feel free to add another column. Hint: Foreign Key.");
		logger.info("9. Insert dependent details (at least 2) for all the employees by getting the information\n"
				+ "	from the commandLine.");
		logger.info("10. List all the dependent details for a given employee. Please note that for a given input\n"
				+ "	either name or employeeID, all the dependent details should be fetched along with\n"
				+ "	the employee Name & employeeID.");
		logger.info("11. Display all the dependent details for the first N employees along with the employee\n"
				+ "	Name & employeeID, sorted by the name in ascending order.");
		logger.info("0. Exit");
	}
}
