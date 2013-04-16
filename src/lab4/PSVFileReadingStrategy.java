package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Machi
 */
public class PSVFileReadingStrategy implements TextFileReadingStrategy {

    @Override
    public void extractFileData() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public List<String[]> readInput() {
	File data = new File("/temp/IOLab.txt");
//	String[] headers = {"First Name:\t", "Last Name:\t", "Street Addres:\t", "City:\t\t", "State:\t\t", "Zip:\t\t"};
	
	List<String[]> records = new ArrayList<String[]>();

	BufferedReader in = null;
	try {
	    in = new BufferedReader(new FileReader(data));
	    String line = in.readLine();

	    int count = 0;
	    while (line != null) {

		String[] recordline = line.split("\\|");
				
		    for (int i = 0; i < recordline.length; i++) {
			
			records <String[i]>  = recordline[i];
			
			
			
//			
		}

		line = in.readLine();
		count++;
	    }

	} catch (IOException ioe) {
	    System.out.println("Houston, we have a problem! reading this file");
	} finally {
	    try {
		in.close();
	    } catch (Exception e) {
	    }
	}
    
    }
    
    
    
}
