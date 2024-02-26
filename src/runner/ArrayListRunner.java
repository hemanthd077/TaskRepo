package runner;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import commonChecker.CommonChecker;
import customException.CustomException;
import helper.ArrayListHelper;

import java.util.ListIterator;

public class ArrayListRunner {
	static Logger logger = Logger.getGlobal();
	public static <T> void main(String[] args) {
		
		try {
			CommonChecker.loggerHandler("LogRecord");
		} catch (CustomException e) {
			e.printStackTrace();
		}
		
		logger.setLevel(Level.ALL);
		
		ArrayListHelper helper = new ArrayListHelper();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			try {
				arrayListMenu();
				choice = scanner.nextInt();
				if(choice<0 || choice>18){
					throw new CustomException("Invalid input!! choice need to be between between 0 to 18.",new InputMismatchException("Entered less than zero or greater than 18."));
				}
				switch (choice) {
					case 1: {
						List<Object> arrayList = helper.getArrayList();
						logger.log(Level.INFO,"Size of the ArrayList : " +  helper.findArrayListLength(arrayList));
						break;
					}
					case 2: {
						
						List<String> arrayList = helper.getArrayList();
							logger.log(Level.INFO,"Enter the No of Strings:");
							int noOfInput = scanner.nextInt();
							scanner.nextLine();
							logger.log(Level.INFO,"Enter the Strings");
							for(int i=0;i<noOfInput;i++){
								helper.addValue(arrayList,scanner.nextLine());
							}
							
							logger.log(Level.INFO,"Size of the ArrayList : " + helper.findArrayListLength(arrayList));
							logger.log(Level.INFO,"The Strings in arrayList : ");
							displayArrayList(arrayList);
						break;
					}
					case 3: {
						List<Integer> arrayList = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Integer:");
						int noOfInput = scanner.nextInt();
						logger.log(Level.INFO,"Enter the Integer");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayList,scanner.nextInt());
						}
						logger.log(Level.INFO,"Size of the ArrayList : " +  helper.findArrayListLength(arrayList));
						logger.log(Level.INFO,"The Integer in arrayList : ");
						displayArrayList(arrayList);	
						break;
					}
					case 4: {
						scanner.nextLine();
						List<Object> arrayList = helper.getArrayList();
						CommonChecker obj = new CommonChecker();
						helper.addValue(arrayList,obj);
						
						logger.log(Level.INFO,"Size of the ArrayList : " +  helper.findArrayListLength(arrayList));
						logger.log(Level.INFO,"The Strings in arrayList : ");
						displayArrayList(arrayList);
						break;
					}
					case 5: {		
						List<Object> arrayList = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Integer:");
						int noOfInput = scanner.nextInt();
						logger.log(Level.INFO,"Enter the Integer");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayList,scanner.nextInt());
						}
						logger.log(Level.INFO,"Enter the No of Strings:");
						noOfInput = scanner.nextInt();
						logger.log(Level.INFO,"Enter the Strings");
						scanner.nextLine();
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayList,scanner.nextLine());
						}
						helper.addValue(arrayList,helper);
						
						logger.log(Level.INFO,"Size of the ArrayList : " +  helper.findArrayListLength(arrayList));
						logger.log(Level.INFO,"The Strings in arrayList : ");
						displayArrayList(arrayList);
						break;
					}
					case 6: {
						List<String> arrayList = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Strings:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayList,scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the String to Search");
						String searchString = scanner.nextLine();
						
						int index = helper.findStringIndexFront(arrayList,searchString);
						if(index==-1){
							logger.log(Level.INFO,"No matches found in the arrayList");
						}
						else{
							logger.log(Level.INFO,"The String Apperas at Position : "+index);
						}
						logger.log(Level.INFO,"Size of the ArrayList : " +  helper.findArrayListLength(arrayList));
						logger.log(Level.INFO,"The Strings in arrayList : ");
						displayArrayList(arrayList);				
						break;
					}
					case 7: {
						List<String> arrayList = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Strings:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayList,scanner.nextLine());
						}
						logger.log(Level.INFO,"Size of the ArrayList : " +  helper.findArrayListLength(arrayList));
						logger.log(Level.INFO,"The Strings in arrayList by Iterator: ");
						ListIterator<String> iterator = arrayList.listIterator();
						while(iterator.hasNext()){
							logger.log(Level.INFO,iterator.next()+" ");
						}
						logger.log(Level.INFO,"The Strings in arrayList by for Loop: ");
						displayArrayList(arrayList);	
						break;
					}
					case 8: {
						List<String> arrayList = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Strings:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayList,scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Index to Get");
						int getIndex = scanner.nextInt();
						logger.log(Level.INFO,"The String Apperas at Position : "+helper.getIndexValue(arrayList,getIndex));
						
						logger.log(Level.INFO,"Size of the ArrayList : " +  helper.findArrayListLength(arrayList));		
						break;
					}
					case 9: {
						List<String> arrayList = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Strings:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayList,scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the String to Search");
						String searchString = scanner.nextLine();
						int frontIndex = helper.findStringIndexFront(arrayList,searchString);
						if(frontIndex==-1){
							logger.log(Level.INFO,"No matches found in the arrayList");
						}
						else{
							logger.log(Level.INFO,"The String Apperas from front Position : "+frontIndex);
							int LastIndex = helper.findStringIndexLast(arrayList,searchString);
							if(LastIndex==-1){
								logger.log(Level.INFO,"No matches found in the arrayList");
							}
							else{
								logger.log(Level.INFO,"The String Apperas from last Position: "+LastIndex);
							}
						}
						logger.log(Level.INFO,"Size of the ArrayList : " + helper.findArrayListLength(arrayList));
						logger.log(Level.INFO,"The Strings in arrayList : ");
						displayArrayList(arrayList);				
						break;
					}
					case 10: {
					
						List<String> arrayList = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Strings:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayList,scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the Index to add");
						int setIndex = scanner.nextInt();
						logger.log(Level.INFO,"Enter the String to add");
						String inputString = scanner.nextLine();
						
						helper.appendCustomPostion(arrayList,inputString,setIndex);
						logger.log(Level.INFO,"Size of the ArrayList : " + helper.findArrayListLength(arrayList));
						logger.log(Level.INFO,"The Strings in arrayList : ");
						displayArrayList(arrayList);			
						break;
					}
	
					case 11: {
						List<String> arrayListOne = helper.getArrayList();
						List<String> arrayListSecond = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Strings:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayListOne,scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the fromIndex to clone");
						int getFromIndex = scanner.nextInt();
						logger.log(Level.INFO,"Enter the toIndex to clone");
						int getToIndex = scanner.nextInt();
						
						arrayListSecond = helper.cloneArrayList(arrayListOne,getFromIndex,getToIndex);
						logger.log(Level.INFO,"Size of the ArrayListOne : " + helper.findArrayListLength(arrayListOne));
						logger.log(Level.INFO,"The Strings in arrayList : ");
						displayArrayList(arrayListOne);	
						logger.log(Level.INFO,"Size of the ArrayListSecond : " + helper.findArrayListLength(arrayListSecond));
						logger.log(Level.INFO,"The Strings in arrayListTwo : ");
						displayArrayList(arrayListSecond);			
						break;
					}
					case 12: {
						List<String> arrayListOne = helper.getArrayList();
						List<String> arrayListSecond = helper.getArrayList();
						List<String> arrayListThree = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Strings for List 1:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayListOne,scanner.nextLine());
						}
						
						logger.log(Level.INFO,"Enter the No of Strings for List 2:");
						noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayListSecond,scanner.nextLine());
						}
						
						helper.addAllArrayList(arrayListThree,arrayListOne);
						helper.addAllArrayList(arrayListThree,arrayListSecond);
						logger.log(Level.INFO,"Size of the arrayListThree : " + helper.findArrayListLength(arrayListThree));	
						logger.log(Level.INFO,"The Strings in arrayListThree : ");
						displayArrayList(arrayListThree);			
						break;
					}
					case 13: {
						List<String> arrayListOne = helper.getArrayList();
						List<String> arrayListSecond = helper.getArrayList();
						List<String> arrayListThree = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Strings for List 1:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayListOne,scanner.nextLine());
						}
						
						logger.log(Level.INFO,"Enter the No of Strings for List 2:");
						noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayListSecond,scanner.nextLine());
						}
						
						helper.addAllArrayList(arrayListThree,arrayListOne);
						helper.addAllArrayList(arrayListThree,arrayListSecond);
						logger.log(Level.INFO,"Size of the arrayListThree : " + helper.findArrayListLength(arrayListThree));	
						logger.log(Level.INFO,"The Strings in arrayListThree : ");
						displayArrayList(arrayListThree);	
						break;
					}
					case 14: {
						List<Double> arrayList = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of values:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Decimal Value");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayList,scanner.nextDouble());
						}
						logger.log(Level.INFO,"Enter the Index to delete");
						int delIndex = scanner.nextInt();
						helper.deleteIndex(arrayList,delIndex);
						logger.log(Level.INFO,"Size of the ArrayList after delete : " + helper.findArrayListLength(arrayList));
						logger.log(Level.INFO,"The Strings in arrayList : ");
						displayArrayList(arrayList);				
						break;
					}
					case 15: {
						List<String> arrayListOne = helper.getArrayList();
						List<String> arrayListSecond = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Strings for List 1:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayListOne,scanner.nextLine());
						}
						
						logger.log(Level.INFO,"Enter the No of Strings for List 2:");
						noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayListSecond,scanner.nextLine());
						}
						
						helper.removeMatchValue(arrayListOne,arrayListSecond);
						logger.log(Level.INFO,"Size of the arrayListThree : " + helper.findArrayListLength(arrayListOne));
						logger.log(Level.INFO,"The Strings in arrayListThree : ");
						displayArrayList(arrayListOne);			
						break;
					}
					case 16: {
						List<String> arrayListOne = helper.getArrayList();
						List<String> arrayListSecond = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Strings for List 1:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayListOne,scanner.nextLine());
						}
						
						logger.log(Level.INFO,"Enter the No of Strings for List 2:");
						noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayListSecond,scanner.nextLine());
						}
						
						helper.removeNotMatchValue(arrayListOne,arrayListSecond);
						logger.log(Level.INFO,"Size of the arrayListThree : " + helper.findArrayListLength(arrayListOne));	
						logger.log(Level.INFO,"The Strings in arrayListThree after remove the date of secondList : ");
						displayArrayList(arrayListOne);			
						break;
					}
					case 17: {
						List<Long> arrayList = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Long for List:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Long values");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayList,scanner.nextLong());
						}
						helper.removeAllValues(arrayList);
						logger.log(Level.INFO,"Size of the arrayList : " + helper.findArrayListLength(arrayList));			
						break;
					}
					case 18: {
						List<String> arrayList = helper.getArrayList();
						logger.log(Level.INFO,"Enter the No of Strings:");
						int noOfInput = scanner.nextInt();
						scanner.nextLine();
						logger.log(Level.INFO,"Enter the Strings");
						for(int i=0;i<noOfInput;i++){
							helper.addValue(arrayList,scanner.nextLine());
						}
						logger.log(Level.INFO,"Enter the String to add");
						String inputString = scanner.nextLine();
						
						if(helper.stringContainCheck(arrayList,inputString)){
							logger.log(Level.INFO,"Yes String Present in the ArrayList");
						}
						else{
							logger.log(Level.INFO,"No match found in the List");
						}
						logger.log(Level.INFO,"Size of the ArrayList : " + helper.findArrayListLength(arrayList));	
						logger.log(Level.INFO,"The Strings in arrayList : ");
						displayArrayList(arrayList);			
						break;
					}
					default:break;
				}
			}
			catch(InputMismatchException e){
				logger.log(Level.SEVERE,"Enter Integer not String",e);
				scanner.nextLine();
			}
			catch (CustomException e) {
				logger.log(Level.SEVERE,e.getMessage(),e);
			}
			catch(Exception e) {
				logger.log(Level.SEVERE,"",e);
			}
		} while (choice != 0);
		logger.log(Level.WARNING,"Exited Successfully");
		scanner.close();
	}

	static void arrayListMenu() {
		logger.log(Level.INFO,"\n----------------------------------------------- Choose the Choice -------------------------------------------------\n");
		logger.log(Level.INFO,"1. Create an ArrayList & print the size");
		logger.log(Level.INFO,"2. Create an ArrayList & add 5 Strings from the command line to it.\n  Print the ArrayList & the size of it");
		logger.log(Level.INFO,"3. Create an ArrayList & add 5 integers from the command line to it.\n  Print the ArrayList & the size of it");
		logger.log(Level.INFO,"4. Create an ArrayList & add your custom objects to it.\n  Print the ArrayList & the size of it");
		logger.log(Level.INFO,"5. Create an ArrayList & add 2 integers, add 3 Strings from command line\n  & 2 custom objects.Print the ArrayList & the size of it");
		logger.log(Level.INFO,"6. ArrayList & add 4 Strings from the command line to it.\n   Then find the index of any one of the already added String");
		logger.log(Level.INFO,"7. Create an ArrayList & add 5 Strings from the command line to it.\n   Use the iterator method & for loop to print each element in the ArrayList");
		logger.log(Level.INFO,"8. Create an ArrayList & add Strings from the command line to it.\n   Print the String at a given index in the ArrayList & the size of it");
		logger.log(Level.INFO,"9. Create an ArrayList & add 5 Strings(with duplicates) from the command line to it.\n   Find the first & last position(index) of a duplicate string");
		logger.log(Level.INFO,"10. create an ArrayList & add 5 Strings from the command line to it.\n    after that add a given String at the 2nd position of the ArrayList.");
		logger.log(Level.INFO,"11. Create an ArrayList(first ArrayList) & add 10 Strings from the command line to it.");
		logger.log(Level.INFO,"    Using that ArrayList create a new ArrayList(second ArrayList) with elements from 3 to 8 position of the first ArrayList");
		logger.log(Level.INFO,"12. Create an ArrayList(first ArrayList) & add 3 Strings from the command line to it.\n    Create another ArrayList(second ArrayList) with 5 more Strings");
		logger.log(Level.INFO,"    from the Command line. Now create another ArrayList (third ArrayLIst) using the\n    above two ArrayLists. Print the third ArrayList & size of it.");
		logger.log(Level.INFO,"13. Create Two ArrayList and Append that to a new third list and print that as well.");
		logger.log(Level.INFO,"14. create an ArrayList & add 5 decimal values from the command line to it.\n    Remove a decimal value at position 4 from the ArrayList.");
		logger.log(Level.INFO,"15. Create Two arraylsit and add values and copy the substring of  firstList to second\n    and generate the third loop by remove the data of second in first");
		logger.log(Level.INFO,"16. Remove the elements from the first ArrayList which are not present in the secondArrayList.\n    Print the ArrayList & the size of it as well.");
		logger.log(Level.INFO,"17. Create an ArrayList & add 10 long values from the command line to it.\n    Remove all the long values from the ArrayLIst.");
		logger.log(Level.INFO,"18. create an ArrayList & add 5 String values from the command line to it.\n    Check whether a given String is present in the ArrayList.");
		logger.log(Level.INFO,"0. Exit");
	}
	
	static  <T>  void displayArrayList(List<T> arrayList){
		for(Object temp : arrayList){
			logger.log(Level.INFO,temp+" ");
		}
	}
}
