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
    
    public TextFileReader() {
	
    
    }

    @Override
    public List< LinkedHashMap<String, String> > readInput(String filePath) {
	
	CsvDecodingStrategy decoder = new CsvDecodingStrategy();
	List<String> recordLines = new ArrayList<>();	
	
	File data = new File(filePath);
//	String[] headers = {"First Name:\t", "Last Name:\t", "Street Addres:\t", "City:\t\t", "State:\t\t", "Zip:\t\t"};

	BufferedReader in = null;
	try {
	    in = new BufferedReader(new FileReader(data));
	    String line = in.readLine();
	     

	    int count = 0;
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
    
    
    // testing the class
    public static void main(String[] args) {
	
	String path = "/temp/IOLab.txt";
	
	TextFileReader fileReader = new TextFileReader();
	
	fileReader.readInput(path);
	
	System.out.println(fileReader.readInput(path).toString());
    }
        
}
