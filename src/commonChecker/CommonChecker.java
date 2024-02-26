package commonChecker;

import customException.CustomException;
import helper.ColoredConsoleHandler;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public final class CommonChecker{
		//null check
	public static void checkNull(Object stringInput) throws CustomException{
		if(stringInput == null){
			throw new CustomException("The NULL Pointer Exception Input is NULL");
		}
	}
	
	//index lesser or greater than string size
	public static void positionCheck(int stringLength,int nthPosition) throws CustomException{
		if(stringLength<nthPosition){
			throw new CustomException("Entered N lesser than string size");
		}
		else if(nthPosition<0){
			throw new CustomException("Entered N greater than 0 and lesser than string size");
		}
	}
	
	public static void indexPositonCheck(int builderLength,int startIndex,int endIndex) throws CustomException{
		if(builderLength<10){
			throw new CustomException("Invalid string size!!",new InputMismatchException("Entered the String lesser 10 character"));
		}
		if(builderLength<startIndex || startIndex<0){
			throw new CustomException("Invalid startIndex!!",new InputMismatchException("Entered startindex need to lesser than String length and greater than zero"));
		}
		if(builderLength<endIndex || endIndex<0){
			throw new CustomException("Invalid endIndex!!",new InputMismatchException("Entered endindex need to lesser than String length and greater than zero"));
		}
	}
	
	public static<T> void indexEdgeCheck(List<T> arrayList,int index) throws CustomException	{
		int size = arrayList.size();
		if(size<=index || index<0) {
			throw new CustomException("Invalid index!!",new IndexOutOfBoundsException("Entered index less than zero or greater than arrayList Size"));
		}
	} 
	
	public static void loggerHandler(String fileName) throws CustomException {
		try {
			Logger logger = Logger.getGlobal();
			checkNull(logger);
			checkNull(fileName);
			ColoredConsoleHandler coloredConsoleHandler = new ColoredConsoleHandler();
	        logger.addHandler(coloredConsoleHandler);
			FileHandler fileHandler = new FileHandler((fileName+".log"),true);
			fileHandler.setFormatter(new SimpleFormatter());
			
			coloredConsoleHandler.setFormatter(new Formatter() {
				
				@Override
				public String format(LogRecord record) {
					
					return record.getLevel()+" "+record.getMessage();
				}
			});
			
	        logger.addHandler(fileHandler);
	        logger.setUseParentHandlers(false);
	        
			
		}
	    catch (SecurityException | IOException e) {
			throw new CustomException("Error occured in loggerHandler",e);
		}
	}
}
