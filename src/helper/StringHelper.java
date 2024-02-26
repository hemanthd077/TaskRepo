package helper;

import customException.CustomException;
import commonChecker.CommonChecker;
import java.util.List;
import java.util.Arrays;

public class StringHelper{
	//1
	public int findLength(String stringInput)  throws CustomException{
		CommonChecker.checkNull(stringInput);
		return stringInput.length();
	}
	
	//2
	public char[] stringToCharArray(String stringInput) throws CustomException{
		CommonChecker.checkNull(stringInput);
		return stringInput.toCharArray();
	}
	
	//3
	public char penultimateFinder(String stringInput,int position) throws CustomException{
		int stringLength = findLength(stringInput);
		CommonChecker.positionCheck(stringLength,position);	
		return stringInput.charAt(stringLength-position);
	}
	
	//4
	public int frequencyFinder(String stringInput,char inputCharacter)  throws CustomException{
		int stringLength = findLength(stringInput);
		int characterCount=0;
		for(int i=0;i<stringLength;i++){
			if(stringInput.charAt(i)==inputCharacter){
				characterCount++;
			}
		}
		return characterCount;
	}
	
	//5
	public int greatestPositionOccured(String stringInput,char inputCharacter) throws CustomException{
		findLength(stringInput);
		return (stringInput.lastIndexOf(inputCharacter)+1);
	}
	
	//6
	public String lastNChar(String stringInput,int nthPosition) throws CustomException{
		int stringLength = findLength(stringInput);
		CommonChecker.positionCheck(stringLength,nthPosition);	
		return stringInput.substring(stringLength-nthPosition,stringLength);
	}
	
	//7
	public String firstNChar(String stringInput,int nthPosition) throws CustomException{
		findLength(stringInput);
		return stringInput.substring(0,nthPosition);
	}
	
	//8
	public String replaceFront(String stringInput,String replaceString,int totalCharacter) throws CustomException{
		CommonChecker.checkNull(replaceString);
		int stringLength = findLength(stringInput);
		CommonChecker.positionCheck(stringLength,totalCharacter);
		return stringInput.replaceFirst(stringInput.substring(0,totalCharacter),replaceString);
	}
	
	//9
	public Boolean stringStartsWith(String stringInput,String stringPattern) throws CustomException{
		CommonChecker.checkNull(stringInput);
		CommonChecker.checkNull(stringPattern);
		return stringInput.startsWith(stringPattern);
	}
	
	//10
	public Boolean stringEndsWith(String stringInput,String stringPattern) throws CustomException{
		CommonChecker.checkNull(stringInput);
		CommonChecker.checkNull(stringPattern);
		return stringInput.endsWith(stringPattern);
	}
	
	//11
	public String toUpper(String stringInput)  throws CustomException{
		CommonChecker.checkNull(stringInput);
		return stringInput.toUpperCase();
	}
	
	//12
	public String toLower(String stringInput) throws CustomException{
		CommonChecker.checkNull(stringInput);
		return stringInput.toLowerCase();
	}
	
	//13
	public String toReverseString(String stringInput) throws CustomException{
		int stringLength = findLength(stringInput);
		char[] characterArray = stringInput.toCharArray();
		for(int indexOne=0,indexTwo = stringLength-1 ;indexOne<indexTwo ;indexOne++,indexTwo--){
			char temp = characterArray[indexOne];
			characterArray[indexOne] = characterArray[indexTwo];
			characterArray[indexTwo] = temp;
		}
		return new String(characterArray);
	}
	
	//15
	public String stringConcateWithReplace(String stringInput,String replaceCharacter,String replaceedCharacter)  throws CustomException{
		CommonChecker.checkNull(stringInput);
		CommonChecker.checkNull(replaceCharacter);
		CommonChecker.checkNull(replaceedCharacter);
		return stringInput.replace(replaceCharacter,replaceedCharacter);
	}
	
	//16
	public String stringToArray(String stringInput,String replaceCharacter)  throws CustomException{
		CommonChecker.checkNull(stringInput);
		CommonChecker.checkNull(replaceCharacter);
		String[] newStringArray = stringInput.split("\\"+replaceCharacter);
		return Arrays.toString(newStringArray);
	}
	
	//17
	public String stringToPattern(List<String> inputStringList,String pattern)  throws CustomException{
		CommonChecker.checkNull(pattern);
		CommonChecker.checkNull(inputStringList);
		return String.join(pattern, inputStringList);
	}
	
	//18
	public Boolean checkEqualStringWithoutCase(String stringInputOne,String stringInputTwo) throws CustomException{
		CommonChecker.checkNull(stringInputOne);
		CommonChecker.checkNull(stringInputTwo);
		return stringInputOne.equalsIgnoreCase(stringInputTwo);
	}
	
	//19
	public Boolean checkEqualStringWithCase(String stringInputOne,String stringInputTwo)  throws CustomException{
		CommonChecker.checkNull(stringInputOne);
		CommonChecker.checkNull(stringInputTwo);
		return stringInputOne.equals(stringInputTwo);
	}
	
	//20
	public String trimString(String stringInput)  throws CustomException{
		CommonChecker.checkNull(stringInput);
		return stringInput.trim();
	}
}
