package helper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import commonChecker.CommonChecker;
import customException.CustomException;

public class ArrayListHelper{
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getArrayList() throws CustomException{
		
		try {
			Class<?> arrayList = Class.forName("java.util.ArrayList");
			Object instance = arrayList.getConstructor().newInstance();
			
			return (List<T>) instance;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new CustomException("Error occured",e);
		}
	}
	
	public <T> List<T> listToArrayList(List<T> list){
		return new ArrayList<>(list);
	}
	
	public <T> int findArrayListLength(List<T> arrayList) throws CustomException {
        CommonChecker.checkNull(arrayList);
        return arrayList.size();
	}
	
	public <T> int findStringIndexFront(List<T> arrayList,String inputString) throws CustomException{
		CommonChecker.checkNull(arrayList);
		CommonChecker.checkNull(inputString);
		return arrayList.indexOf(inputString);
	}
	
	public <T> int findStringIndexLast(List<T> arrayList,String inputString) throws CustomException{
		CommonChecker.checkNull(arrayList);
		CommonChecker.checkNull(inputString);
		return arrayList.lastIndexOf(inputString);
	}
	
	public <T> T getIndexValue(List<T> arrayList,int inputIndex) throws CustomException{
		CommonChecker.checkNull(arrayList);
		CommonChecker.indexEdgeCheck(arrayList,inputIndex);
		return arrayList.get(inputIndex);
	}
	
	public <T> void addValue(List<T> arrayList,T inputValue) throws CustomException{
		CommonChecker.checkNull(arrayList);
		CommonChecker.checkNull(inputValue);
		arrayList.add(inputValue);
	}
	
	public <T> void appendCustomPostion(List<T> arrayList,T inputValue,int inputIndex) throws CustomException{
		CommonChecker.checkNull(arrayList);
		CommonChecker.checkNull(inputValue);
		CommonChecker.indexEdgeCheck(arrayList,inputIndex);
		arrayList.add(inputIndex,inputValue);
	}
	
	public <T> List<T> cloneArrayList(List<T> arrayList,int fromIndex,int toIndex) throws CustomException{
		CommonChecker.checkNull(arrayList);
		CommonChecker.indexEdgeCheck(arrayList,fromIndex);
		CommonChecker.indexEdgeCheck(arrayList,toIndex);
		if(fromIndex>toIndex) {
			throw new CustomException("Entered frontIndex>toIndex");
		}
		return listToArrayList(arrayList.subList(fromIndex,toIndex));
	}
	
	public <T> void addAllArrayList(List<T> arrayListTo,List<T> arrayListFrom) throws CustomException{
		CommonChecker.checkNull(arrayListTo);
		CommonChecker.checkNull(arrayListFrom);
		arrayListTo.addAll(arrayListFrom);
	}
	
	public <T> void deleteIndex(List<T> arrayList,int delIndex) throws CustomException{
		CommonChecker.checkNull(arrayList);
		CommonChecker.indexEdgeCheck(arrayList,delIndex);
		arrayList.remove(delIndex);
	}
	
	public <T> void removeMatchValue(List<T> arrayListOne,List<T> arrayListTwo) throws CustomException{
		CommonChecker.checkNull(arrayListOne);
		CommonChecker.checkNull(arrayListTwo);
		arrayListOne.removeAll(arrayListTwo);
	}
	
	public <T> void removeNotMatchValue(List<T> arrayListOne,List<T> arrayListTwo) throws CustomException{
		CommonChecker.checkNull(arrayListOne);
		CommonChecker.checkNull(arrayListTwo);
		arrayListOne.retainAll(arrayListTwo);
	}	
	
	public <T> void removeAllValues(List<T> arrayList) throws CustomException{
		CommonChecker.checkNull(arrayList);
		arrayList.clear();
	}
	
	public <T> boolean stringContainCheck(List<T> arrayList,String inputString) throws CustomException{
		CommonChecker.checkNull(arrayList);
		CommonChecker.checkNull(inputString);
		return arrayList.contains(inputString);
	}
}

