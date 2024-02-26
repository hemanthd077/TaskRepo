package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import commonChecker.CommonChecker;
import customException.CustomException;

public class PropertyHelper {
	
	BasicProgrammingHelper helper = new BasicProgrammingHelper();
	
	private Properties properties;
	
	public PropertyHelper() {
		properties =  new Properties();
	}
	
	public void setProperties(String key ,String value) throws CustomException{
		CommonChecker.checkNull(key);
		CommonChecker.checkNull(value);
		properties.setProperty(key, value);
	}
	
	public Properties getProperties(){
		return properties;
	}
	
	public OutputStream getFileOutputStream(File fileFormat) throws CustomException {
		try {
			CommonChecker.checkNull(fileFormat);
			return new FileOutputStream(fileFormat);
		}
		catch(IOException e) {
			throw new CustomException("IO Exception Ocuured : ",e);
		}
	}
	
	public InputStream getFileInputStream(File fileFormat) throws CustomException {
		try {
			CommonChecker.checkNull(fileFormat);
			return new FileInputStream(fileFormat);
		}
		catch(IOException e) {
			throw new CustomException("IO Exception Ocuured : ",e);
		}
	}
	
	public void storeProperties(OutputStream fileStream) throws CustomException{
		try {
			properties.store(fileStream,"Adding the Properties");
		}
		catch(IOException e) {
			throw new CustomException("Input output Exception Occured : ",e);
		}
	}
	
	public void loadProperties(InputStream inputStream) throws CustomException {
		try {
			properties.load(inputStream);
		}
		catch(IOException e) {
			throw new CustomException("Input output Exception Occured : ",e);
		}
	}
	
	public boolean propertiesFileCreation(String fileName,String filePath){
		try {
			File file = helper.generateFolderFile(filePath);
			helper.createDirectory(file);
			File tempFile = helper.pathSeperator(filePath,fileName);
			OutputStream fileOutputStream = getFileOutputStream(tempFile);
			storeProperties(fileOutputStream);
			return true;
		}
		catch(CustomException e) {
			return false;
		}
	}
	
	public void propertiesFileReadandLoad(String fileName,String filePath) throws CustomException{
		File tempFile = helper.pathSeperator(filePath,fileName);
		loadProperties(getFileInputStream(tempFile));
	}
}

