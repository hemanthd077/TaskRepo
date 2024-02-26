package helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import commonChecker.CommonChecker;
import customException.CustomException;

public class BasicProgrammingHelper {
	
//	ArrayListHelper arrayHelper = new ArrayListHelper();
	
	public File generateFolderFile(String fileName) throws CustomException {
		CommonChecker.checkNull(fileName);
		return new File(fileName);
	}
	
	public void createDirectory(File folder) throws CustomException {
		CommonChecker.checkNull(folder);
		folder.mkdirs();
	}
	
	public File pathSeperator(String filePath,String fileName) throws CustomException {
		CommonChecker.checkNull(fileName);
		CommonChecker.checkNull(filePath);
		return new File(filePath,fileName);
	}
	
	public Writer getBufferWriter(Writer file) throws CustomException{
		CommonChecker.checkNull(file);
		return new BufferedWriter(file);
	}
	
	public File generateFile(File file,String fileFormate) throws CustomException	{
		CommonChecker.checkNull(fileFormate);
		CommonChecker.checkNull(file);
		return new File(file,fileFormate);
	}
	
	public Writer generateFileWritter(File file) throws CustomException {
		try {
			CommonChecker.checkNull(file);
			return new FileWriter(file);
		}
		catch(IOException e) {
			throw new CustomException("IO Exception Occured :",e);
		}
	}

	public void fileWrite(Writer writter,String inputText) throws IOException {
		writter.write(inputText+"\n");
	}
	
	public boolean createFile(List<String> list,String fileName,String filePath) throws CustomException{
		
		try {
	        File file = generateFolderFile(filePath);
	        createDirectory(file);

	        try (Writer newFile = generateFileWritter(pathSeperator(filePath, fileName));
	             Writer bufferWriter = getBufferWriter(newFile)) {

	            int length = list.size();
	            for (int i = 0; i < length; i++) {
	                fileWrite(bufferWriter, list.get(i));
	            }

	            return true;
	        }
	    } catch (IOException e) {
	        throw new CustomException("IO Exception Occurred: ", e);
	    }
	}
	
//	public List<String> readFile(String fileName,String filePath) throws CustomException {
//		try {
//			File readFile = new File("GeneratedTextFile/sample.txt");
//			FileReader fileReader = new FileReader(readFile);
//			
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			
//			List<String> list = arrayHelper.getArrayList();
//			String str;
//			while((str=bufferedReader.readLine())!=null) {
//				list.add(str);
//			}	
//			bufferedReader.close();
//			return list;
//		}
//		catch(IOException e) {
//			throw new CustomException("IO Exception Occured");
//		}
//	}
}
