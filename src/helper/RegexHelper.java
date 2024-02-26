package helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import commonChecker.CommonChecker;
import customException.CustomException;

public class RegexHelper {
	
	public boolean checkValidNumber(String number) throws CustomException {
		CommonChecker.checkNull(number);
		return number.matches("[7-9]{1}\\d{9}");
	}
	
	public boolean checkValidAlphaNumeric(String inputString) throws CustomException {
		CommonChecker.checkNull(inputString);
		return inputString.matches("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])[a-zA-Z\\d]+$");
	}
	
	public boolean startsWith(String inputStringOne,String inputStringTwo) throws CustomException {
		CommonChecker.checkNull(inputStringTwo);
		CommonChecker.checkNull(inputStringOne);
		return inputStringTwo.matches("^\\Q"+inputStringOne+"\\E.*$");
	}
	
	public boolean endsWith(String inputStringOne,String inputStringTwo) throws CustomException {
		CommonChecker.checkNull(inputStringTwo);
		CommonChecker.checkNull(inputStringOne);
		return inputStringTwo.matches("^.*\\Q"+inputStringOne+"\\E+$");
	}
	
	public boolean checkEquals(String inputStringOne,String inputStringTwo) throws CustomException {
		CommonChecker.checkNull(inputStringTwo);
		CommonChecker.checkNull(inputStringOne);
		return inputStringTwo.matches("^\\Q"+inputStringOne+"\\E+$");
	}
	
	public boolean checkContains(String inputStringOne,String inputStringTwo) throws CustomException {
		CommonChecker.checkNull(inputStringTwo);
		CommonChecker.checkNull(inputStringOne);
		return inputStringTwo.matches("^.*\\Q"+inputStringOne+"\\E.*$");
	}
	
	public boolean arrayCheckEqual(List<String> listString,String inputString) throws CustomException {
		CommonChecker.checkNull(listString);
		CommonChecker.checkNull(inputString);
		
		for(String temp : listString) {
			if(temp.matches("(?i)"+inputString)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkValidEmail(String inputString) throws CustomException {
		CommonChecker.checkNull(inputString);
		return inputString.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}$");
	}
	
	public boolean checkValidLength(List<String> listString,int min,int max) throws CustomException {
		CommonChecker.checkNull(listString);
		if(min>max) {
			throw new CustomException("enter valid min and max number");
		}
		for(String temp : listString) {
			
			if(!temp.matches("^.{"+min+","+max+"}+$")) {
				return false;
			}
		}
		return true;
	}
	
	public List<String> getTags(String inputString){
		Pattern pattern = Pattern.compile("<[^<]+>");
		Matcher matcher = pattern.matcher(inputString);
		
		List<String> list = new ArrayList<>();
		while(matcher.find()) {
			String temp = matcher.group();
			list.add(temp);
		}
		return list;
	}
	
	public Map<String,Integer> checkMatchingString(List<String> strings,List<String> matchingString) throws CustomException{
		Map<String, Integer> map = new HashMap<>();
		
//		String newString = matchingString.toString();
//		newString = newString.replace("[", "");
//		newString = newString.replace("]", "");
//		newString = newString.replace(", ", "|");
//		Pattern pattern = Pattern.compile("\\b("+newString+")\\b");
		
        Pattern pattern = Pattern.compile("\\b("+String.join("|", matchingString)+")\\b");
        int stringSize = strings.size();
        for (int i = 0; i < stringSize; i++) {
            String currentString = strings.get(i);
            if (pattern.matcher(currentString).find()) {
                map.put(currentString, i);
            }
        }
		return map;
	}
}
