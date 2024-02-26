package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commonChecker.CommonChecker;
import customException.CustomException;
import database.ConnectionCreation;

public class JdbcHelper {
	
	public boolean createTableEmployee() throws CustomException {
		Connection connection = ConnectionCreation.getConnection();
		String sqlQuery = "create table if not exists Employee(EMPLOYEE_ID int AUTO_INCREMENT,NAME varchar(50),"
						+ "MOBILE Long,EMAIL varchar(50),DEPARTMENT varchar(30), primary key (EMPLOYEE_ID))";
		
		try (PreparedStatement createStatement = connection.prepareStatement(sqlQuery)){
			return createStatement.executeUpdate()==0;
		} catch (SQLException e) {
			throw new CustomException("Error occured in createTable :",e);
		}
	}
	
	public boolean insertValueEmployee(List<Employee> list) throws CustomException {
		CommonChecker.checkNull(list);
		Connection connection = ConnectionCreation.getConnection();
		String insertQuery = "insert into Employee(NAME,MOBILE,EMAIL,DEPARTMENT) values(?,?,?,?)";
		try(PreparedStatement insertStatement = connection.prepareStatement(insertQuery)){
			int listSize = list.size();
			for(int i=0;i<listSize;i++) {
				insertStatement.setString(1, list.get(i).getEmployeeName());
				insertStatement.setLong(2, list.get(i).getEmployeeMobileNo());
				insertStatement.setString(3, list.get(i).getEmployeeEmail());
				insertStatement.setString(4, list.get(i).getEmployeeDepartment());
				insertStatement.addBatch();
			}
			System.out.println(insertStatement);
			return insertStatement.executeBatch().length!=0;
		} catch (SQLException e) {
			throw new CustomException("Exception occured while inserting value: ",e);
		}
	}
	
	public List<Employee> getEmployeeData(String name) throws CustomException{
		List<Employee> list = new ArrayList<>();
		Connection connection = ConnectionCreation.getConnection();
		String sqlQuery = "select * from Employee where NAME = ?;";
		try(PreparedStatement selectStatement = connection.prepareStatement(sqlQuery)){
			selectStatement.setString(1, name);
			try(ResultSet resultSet = selectStatement.executeQuery()){
				while(resultSet.next()) {
					Employee employee = new Employee();
					employee.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
					employee.setEmployeeName(resultSet.getString("NAME"));
					employee.setEmployeeMobileNo(resultSet.getLong("MOBILE"));
					employee.setEmployeeEmail(resultSet.getString("EMAIL"));
					employee.setEmployeeDepartment(resultSet.getString("DEPARTMENT"));
					list.add(employee);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured in getting EmployeeData :",e);
		}
		return list;
	}
	
	public boolean updateRecord(String changeValue,String fieldName,int employeId) throws CustomException {
		CommonChecker.checkNull(employeId);
		CommonChecker.checkNull(fieldName);
		CommonChecker.checkNull(changeValue);
		Connection connection = ConnectionCreation.getConnection();
		fieldName =  fieldName.toUpperCase();
		String sqlQuery = "update Employee set "+fieldName+" = ? where EMPLOYEE_ID = ?;";
		try(PreparedStatement updateStatement = connection.prepareStatement(sqlQuery)){
			updateStatement.setString(1, changeValue);
			updateStatement.setInt(2, employeId);
			return updateStatement.executeUpdate()!=0;
		} catch (SQLException e) {
			throw new CustomException("Error occured in updateing Record :",e);
		}	
	}
	
	public List<Employee> getFirstN(int limit) throws CustomException{
		List<Employee> list = new ArrayList<>();
		Connection connection = ConnectionCreation.getConnection();
		String sqlQuery = "select * from Employee order by EMPLOYEE_ID limit ?";
		try(PreparedStatement selectStatement = connection.prepareStatement(sqlQuery)){
			selectStatement.setInt(1, limit);
			try(ResultSet resultSet = selectStatement.executeQuery()){
				while(resultSet.next()) {
					Employee employee = new Employee();
					employee.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
					employee.setEmployeeName(resultSet.getString("NAME"));
					employee.setEmployeeMobileNo(resultSet.getLong("MOBILE"));
					employee.setEmployeeEmail(resultSet.getString("EMAIL"));
					employee.setEmployeeDepartment(resultSet.getString("DEPARTMENT"));
					list.add(employee);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured in getting EmployeeData :",e);
		}
		return list;
	}
	
	public List<Employee> getBySorted(int limit,int state,String fieldName) throws CustomException{
		List<Employee> list = new ArrayList<>();
		Connection connection = ConnectionCreation.getConnection();
		fieldName =  fieldName.toUpperCase();
		String sortType = (state==-1)? "desc" : "asc";
		String sqlQuery = "select * from Employee order by "+fieldName+" "+sortType+" limit ?;";
		try(PreparedStatement selectStatement = connection.prepareStatement(sqlQuery)){
			selectStatement.setInt(1, limit);
			try(ResultSet resultSet = selectStatement.executeQuery()){
				while(resultSet.next()) {
					Employee employee = new Employee();
					employee.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
					employee.setEmployeeName(resultSet.getString("NAME"));
					employee.setEmployeeMobileNo(resultSet.getLong("MOBILE"));
					employee.setEmployeeEmail(resultSet.getString("EMAIL"));
					employee.setEmployeeDepartment(resultSet.getString("DEPARTMENT"));
					list.add(employee);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured in sorting n element :",e);
		}
		return list;
	}
	
	public boolean deleteRecord(int employeId) throws CustomException {
		Connection connection = ConnectionCreation.getConnection();
		String sqlQuery = "delete from Employee where EMPLOYEE_ID = ?;";
		try(PreparedStatement updateStatement = connection.prepareStatement(sqlQuery)){
			updateStatement.setInt(1, employeId);
			return updateStatement.executeUpdate()!=0;
		} catch (SQLException e) {
			throw new CustomException("Error occured in updateing Record :",e);
		}	
	}
	//surrogate key
	public boolean createTableDependent() throws CustomException {
		Connection connection = ConnectionCreation.getConnection();
		String sqlQuery = "CREATE TABLE IF NOT EXISTS Dependent (DEPENDENT_ID INT AUTO_INCREMENT PRIMARY KEY, " +
                "NAME VARCHAR(50), " +
                "AGE INT, " +
                "RELATIONSHIP VARCHAR(50), " +
                "EMPLOYEE_ID int, " +
                "FOREIGN KEY (EMPLOYEE_ID) REFERENCES Employee(EMPLOYEE_ID) ON DELETE CASCADE);";

		try (PreparedStatement createStatement = connection.prepareStatement(sqlQuery)){
			return createStatement.executeUpdate()==0;
		} catch (SQLException e) {
			throw new CustomException("Error occured in createTable :",e);
		}
	}
	
	public boolean insertValueDependent(List<Dependent> list) throws CustomException {
		CommonChecker.checkNull(list);
		Connection connection = ConnectionCreation.getConnection();
		String insertQuery = "insert into Dependent(NAME,AGE,RELATIONSHIP,EMPLOYEE_ID) values(?,?,?,?);";
		try(PreparedStatement insertStatement = connection.prepareStatement(insertQuery)){
			int listSize = list.size();
			for(int i=0;i<listSize;i++) {
				insertStatement.setString(1, list.get(i).getDependentName());
				insertStatement.setLong(2, list.get(i).getDependentAge());
				insertStatement.setString(3, list.get(i).getDependentRelationship());
				insertStatement.setString(4, list.get(i).getDependentEmployee_id());
				insertStatement.addBatch();
			}
			
			return insertStatement.executeBatch().length!=0;
		} catch (SQLException e) {
			throw new CustomException("Exception occured while inserting value: ",e);
		}
	}
	
	public Map<Integer,Employee> getEmployeeFullData(int empId) throws CustomException{
		Map<Integer,Employee> map = new HashMap<>();
		Connection connection = ConnectionCreation.getConnection();
		String sqlQuery = "select E.EMPLOYEE_ID, E.NAME as EMPLOYEE_NAME, D.NAME as DEPENDENT_NAME, DEPENDENT_ID, "
						+ "AGE as DEPENDENT_AGE, RELATIONSHIP as DEPENDENT_RELATIONSHIP from Employee E join "
						+ "Dependent D on E.EMPLOYEE_ID = D.EMPLOYEE_ID where E.EMPLOYEE_ID = ?";
		
		try(PreparedStatement selectStatement = connection.prepareStatement(sqlQuery)){
			selectStatement.setInt(1, empId);
			try(ResultSet resultSet = selectStatement.executeQuery()){
				while (resultSet.next()) {
                    int employeeId = resultSet.getInt("EMPLOYEE_ID");
                    if (!map.containsKey(employeeId)) {
                        Employee employee = new Employee();
                        employee.setEmployeeId(employeeId);
                        employee.setEmployeeName(resultSet.getString("EMPLOYEE_NAME"));
                        employee.setDependent(new ArrayList<>());
                        map.put(employeeId, employee);
                    }

                    Dependent dependent = new Dependent();
                    dependent.setDependentId(resultSet.getString("DEPENDENT_ID"));
                    dependent.setDependentName(resultSet.getString("DEPENDENT_NAME"));
                    dependent.setDependentAge(resultSet.getInt("DEPENDENT_AGE"));
                    dependent.setDependentRelationship(resultSet.getString("DEPENDENT_RELATIONSHIP"));

                    map.get(employeeId).getDependent().add(dependent);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured in getting EmployeeData :",e);
		}
		return map;
	}
	
	public Map<Integer,Employee> getEmployeeFirstN(int n) throws CustomException{
		Map<Integer,Employee> map = new HashMap<>();
		Connection connection = ConnectionCreation.getConnection();
		String sqlQuery = "select E.EMPLOYEE_ID, E.NAME as EMPLOYEE_NAME, D.NAME as DEPENDENT_NAME, DEPENDENT_ID, "
						+ "AGE as DEPENDENT_AGE, RELATIONSHIP as DEPENDENT_RELATIONSHIP from Employee E join "
						+ "Dependent D on E.EMPLOYEE_ID = D.EMPLOYEE_ID  order by DEPENDENT_ID limit ?";
		try(PreparedStatement selectStatement = connection.prepareStatement(sqlQuery)){
			selectStatement.setInt(1, n);
			try(ResultSet resultSet = selectStatement.executeQuery()){
				while (resultSet.next()) {
                    int employeeId = resultSet.getInt("EMPLOYEE_ID");
                    if (!map.containsKey(employeeId)) {
                        Employee employee = new Employee();
                        employee.setEmployeeId(employeeId);
                        employee.setEmployeeName(resultSet.getString("EMPLOYEE_NAME"));
                        employee.setDependent(new ArrayList<>());
                        map.put(employeeId, employee);
                    }

                    Dependent dependent = new Dependent();
                    dependent.setDependentId(resultSet.getString("DEPENDENT_ID"));
                    dependent.setDependentName(resultSet.getString("DEPENDENT_NAME"));
                    dependent.setDependentAge(resultSet.getInt("DEPENDENT_AGE"));
                    dependent.setDependentRelationship(resultSet.getString("DEPENDENT_RELATIONSHIP"));

                    map.get(employeeId).getDependent().add(dependent);
                }
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured in getting EmployeeData :",e);
		}
		return map;
	}
}
