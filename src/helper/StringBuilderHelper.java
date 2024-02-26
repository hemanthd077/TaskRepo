package helper;

import commonChecker.CommonChecker;
import customException.CustomException;
import java.util.InputMismatchException;

public class StringBuilderHelper{

	public static String[] getStringArray(int length){
		
		return new String[length];
	}

	public static StringBuilder getStringBuilder(){
		return new StringBuilder();
	}
	
	public String buildertoString(StringBuilder stringBuilder) throws CustomException{
		CommonChecker.checkNull(stringBuilder);
		return stringBuilder.toString();
	}
	
	public int stringBuilderLength(StringBuilder stringBuilder) throws CustomException{
		CommonChecker.checkNull(stringBuilder);
		return stringBuilder.length();
	}
	
	//1
	public StringBuilder appendValue(StringBuilder stringBuilder,String inputString)  throws CustomException{
		CommonChecker.checkNull(inputString);
		CommonChecker.checkNull(stringBuilder);
		stringBuilder.append(inputString);
		return stringBuilder;
	}
	
	//2
	public StringBuilder joinDelimters(StringBuilder stringBuilder,String[] stringArray,String delimiters)  throws CustomException{
		CommonChecker.checkNull(stringArray);
		int noOfStrings = stringArray.length;
		for(int index=0 ;index<noOfStrings;index++){
			stringBuilder = appendValue(stringBuilder,delimiters);
			stringBuilder = appendValue(stringBuilder,stringArray[index]);
		}
		return stringBuilder;
	}
	
	//3 
	public StringBuilder appendBetween(StringBuilder stringBuilder,String inputString,String delimiters) throws CustomException{
		stringBuilderLength(stringBuilder);
		CommonChecker.checkNull(inputString);
		CommonChecker.checkNull(delimiters);
		int index = stringBuilder.indexOf(delimiters);
		if(index==-1){
			throw new CustomException("No delimiters found",new InputMismatchException("Entered or passed wrong input"));
		}
		stringBuilder = stringBuilder.insert(index,delimiters);
		int delimitersLength = delimiters.length();
		return stringBuilder.insert(index+delimitersLength,inputString);
	}
	
	//4
	public StringBuilder deleteFirstString(StringBuilder stringBuilder,String delimiters) throws CustomException{
		CommonChecker.checkNull(stringBuilder);
		CommonChecker.checkNull(delimiters);
		int index = stringBuilder.indexOf(delimiters);
		if(index==-1){
			throw new CustomException("No delimiters found",new InputMismatchException("Entered or passed wrong input"));
		}
		return stringBuilder.delete(0,index);
	}
	
	//5 
	public StringBuilder delimeterReplace(StringBuilder stringBuilder,String oldDelimiters,String newDelimiters) throws CustomException{
		CommonChecker.checkNull(newDelimiters);
		CommonChecker.checkNull(oldDelimiters);
		int builderLength = stringBuilderLength(stringBuilder);
		int checkDelimiterLength = oldDelimiters.length();
		int index= stringBuilder.indexOf(oldDelimiters,0);
		while(index!=-1){
			if (index + checkDelimiterLength > builderLength) {
	     			 break;
			}
			stringBuilder.replace(index, index + checkDelimiterLength, newDelimiters);
			builderLength = stringBuilder.length();
			index = stringBuilder.indexOf(oldDelimiters, index + checkDelimiterLength);
		}
		return stringBuilder;
	}
	
	//6
	public StringBuilder stringReverse(StringBuilder stringBuilder) throws CustomException{
		CommonChecker.checkNull(stringBuilder);
		return stringBuilder.reverse();
	}
	
	//7
	public StringBuilder deleteParticularSubstring(StringBuilder stringBuilder,int startIndex,int endIndex)  throws CustomException{
		int builderLength = stringBuilderLength(stringBuilder);
		CommonChecker.indexPositonCheck(builderLength,startIndex,endIndex);
		stringBuilder = stringBuilder.delete(startIndex,endIndex);
		return stringBuilder;
	}
	
	//8
	public StringBuilder replaceParticularSubstring(StringBuilder stringBuilder,int startIndex,int endIndex,String replaceString)  throws CustomException{
		int builderLength = stringBuilderLength(stringBuilder);
		CommonChecker.checkNull(replaceString);
		CommonChecker.indexPositonCheck(builderLength,startIndex,endIndex);
		return stringBuilder.replace(startIndex,endIndex,replaceString);
	}
	
	//9
	public int findFirstIndexOfDelimiters(StringBuilder stringBuilder,String delimiters) throws CustomException{
		CommonChecker.checkNull(stringBuilder);
		CommonChecker.checkNull(delimiters);
		return stringBuilder.indexOf(delimiters);
	}
	
	//10
	public int findLastIndexOfDelimiters(StringBuilder stringBuilder,String delimiters) throws CustomException{
		stringBuilderLength(stringBuilder);
		CommonChecker.checkNull(delimiters);
		return stringBuilder.lastIndexOf(delimiters);
	}
}
