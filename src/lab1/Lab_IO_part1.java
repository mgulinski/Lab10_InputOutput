package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Machi
 */
public class Lab_IO_part1 {

    public static void main(String[] args) {

//	File data = new File(File.separatorChar + "temp" + File.separatorChar 
//                        + "test.txt");

	File data = new File("/temp/IOLab.txt");
	
	String[] headers = { "First Name:\t", "Last Name:\t", "Street Addres:\t", "City:\t\t", "State:\t\t", "Zip:\t\t" };

	BufferedReader in = null;
	try {
	    in = new BufferedReader(new FileReader(data));
	    String line = in.readLine();
	    

	    while (line != null) {
		
		String[] recordline = line.split("\\|");
//		System.out.println(recordline[1] + " " + recordline[0]);
		
		for (int i = 0; i < recordline.length; i++) {
		    
		    System.out.println(headers[i] + recordline[i]);
		}
		
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


    }
}
