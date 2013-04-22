package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Machi
 */
public class TextFileReader implements FileInputStrategy {
    
    String filePath = null;
    
    FileDecodingStrategy decoder;
    
    /**
     * constructors
     * @param decoder 
     */ 
    public TextFileReader(FileDecodingStrategy decoder) {	
	this.decoder = decoder;   
    }
    
    public TextFileReader() {}
    
    
    
    /**
     * public getters and setters
     * @return 
     */

    public String getFilePath() {
	return filePath;
    }

    public void setFilePath(String filePath) {
	this.filePath = filePath;
    }

    public FileDecodingStrategy getDecoder() {
	return decoder;
    }

    public void setDecoder(FileDecodingStrategy decoder) {
	this.decoder = decoder;
    }
    
 
    
    @Override
    public List< LinkedHashMap<String, String> > inputData(String filePath) {
	
	List<String> recordLines = new ArrayList<>();	
	
	File data = new File(filePath);
//	String[] headers = {"First Name:\t", "Last Name:\t", "Street Addres:\t", "City:\t\t", "State:\t\t", "Zip:\t\t"};

	BufferedReader in = null;
	try {
	    in = new BufferedReader(new FileReader(data));
	    String line = in.readLine();
	     
	    while (line != null) {		
		  recordLines.add(line);
		  line = in.readLine();
	    }
	    
   
	} catch (IOException ioe) {
	    System.out.println("Houston, we have a problem! reading this file");
	} finally {
	    try {
		in.close();
	    } catch (Exception e) {
	    }
	}
	
	 return decoder.decodeData(recordLines);
    }
    
//    
//    // testing the class
//    public static void main(String[] args) {
//	
//	String path = "/temp/IOLab.txt";
//	
//	TextFileReader fileReader = new TextFileReader(new CsvDecoder());
//	
//	fileReader.inputData(path);
//	
//	System.out.println(fileReader.inputData(path).toString());
//    }
        
}
