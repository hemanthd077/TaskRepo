package helper;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import commonChecker.CommonChecker;
import customException.CustomException;

public class HashMapHelper {
	@SuppressWarnings("unchecked")
	public <K,V> Map<K,V> getHashMap() throws CustomException{
		try {
			Class<?> hashmap = Class.forName("java.util.HashMap");
			Object instance = hashmap.getConstructor().newInstance();
			return (Map<K,V>) instance;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new CustomException("Error Occured in arrayListOperation",e);
		}
	}
	
	public <K,V> void mapPut(Map<K,V> map,K key,V value){
		map.put(key, value);
	}
	
	public <K,V> int getHashMapSize(Map<K,V> map) throws CustomException {
		CommonChecker.checkNull(map);
		return map.size();
	}

	public <K,V> boolean checkKeyExist(Map<K,V> map,K keyCheck) throws CustomException {
		CommonChecker.checkNull(map);
		CommonChecker.checkNull(keyCheck);
		return map.containsKey(keyCheck);
	}
	
	public <K,V> boolean checkValueExist(Map<K,V> map,V valueCheck) throws CustomException {
		CommonChecker.checkNull(map);
		CommonChecker.checkNull(valueCheck);
		return map.containsValue(valueCheck);
	}
	
	public <K,V> V getKeyValue(Map<K,V> map,K key) throws CustomException {
		CommonChecker.checkNull(map);
		CommonChecker.checkNull(key);
		return map.get(key);
	}
	
	public <K,V> V getWordWhileNull(Map<K,V> map,K key,V value) throws CustomException {
		CommonChecker.checkNull(map);
		CommonChecker.checkNull(key);
		return map.getOrDefault(key,value);
	}
	
	public <K,V> void changeAllValue(Map<K,V> map,V value) throws CustomException {
		CommonChecker.checkNull(map);
		CommonChecker.checkNull(value);
		for (Map.Entry<K, V> entry : map.entrySet()) {
			entry.setValue(value);
		}
	}
	
	public <K,V> void mapRemoveKey(Map<K,V> map,K key) throws CustomException {
		CommonChecker.checkNull(map);
		map.remove(key);
		
	}
	
	public <K,V> void mapRemoveKeyWithValue(Map<K,V> map,K key,V value) throws CustomException {
		CommonChecker.checkNull(map);
		CommonChecker.checkNull(value);
		map.remove(key,value);
	}
	
	public <K,V> void mapReplaceValue(Map<K,V> map,K key,V value) throws CustomException {
		CommonChecker.checkNull(map);
		CommonChecker.checkNull(value);
		map.replace(key,value);
	}
	
	public <K,V> void mapReplaceByExistValue(Map<K,V> map,K key,V oldValue,V newValue) throws CustomException {
		CommonChecker.checkNull(map);
		CommonChecker.checkNull(oldValue);
		CommonChecker.checkNull(newValue);
		map.replace(key,oldValue,newValue);
	}
	
	public <K,V> void mapCopyAll(Map<K,V> oldMap,Map<K,V> newMap) throws CustomException {
		CommonChecker.checkNull(oldMap);
		CommonChecker.checkNull(newMap);
		newMap.putAll(oldMap);
	}
	
	public <K,V> void mapClearAll(Map<K,V> map) throws CustomException{
		CommonChecker.checkNull(map);
		map.clear();
	}
}
