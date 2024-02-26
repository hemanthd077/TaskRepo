package serializingDeserializing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.json.JSONObject;
import org.json.JSONTokener;

import customException.CustomException;

public class TaskHelper {
	
	public <T> void serializingObject(T object,String fileName) throws CustomException  {
			try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
				outputStream.writeObject(object);
			} catch (IOException e) {
				throw new CustomException("Error Occured in serializing the Object:",e);
			}
	}
	
	public <T> T deserializingObject(String fileName) throws CustomException  {
		try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))){
			@SuppressWarnings("unchecked")
			T temp = (T)inputStream.readObject();
			return (T) temp;
		} catch (ClassNotFoundException | IOException e) {
			throw new CustomException("Error Occured in deserializing the file:",e);
		}
	}
	
	public <T> void serializingJSON(T object,String fileName) throws CustomException  {
		try(FileWriter fileWriter = new FileWriter(fileName)){
			fileWriter.write(object.toString());
		} catch (IOException e) {
			throw new CustomException("Error Occured in serializing the Object:",e);
		}
}
	
	@SuppressWarnings("unchecked")
	public <T> T deserializingJSON(String fileName) throws CustomException {

        try (FileReader reader = new FileReader(fileName)) {
        	JSONObject jsonObject = new JSONObject(new JSONTokener(reader));
        	return (T) jsonObject; 
        } catch (IOException e) {	
        	throw new CustomException("Error Occured in deserializing the JSON file:",e);
		}
	}
}
