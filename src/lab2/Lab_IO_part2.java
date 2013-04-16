package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author Machi
 */
public class Lab_IO_part2 {

    public static void main(String[] args) {

//	File data = new File(File.separatorChar + "temp" + File.separatorChar 
//                        + "test.txt");

	File data = new File("/temp/IOLab.txt");
	String[] headers = { "First Name:\t", "Last Name:\t", "Street Addres:\t", 
			     "City:\t\t", "State:\t\t", "Zip:\t\t" };
	
	
	
	BufferedReader in = null;
	try {
	    
	    Integer record = Lab_IO_part2.getRecordNumber();
	    in = new BufferedReader(new FileReader(data));
	    String line = in.readLine();
	   

	    int count = 0;
	    while (line != null) {

		String[] recordline = line.split("\\|");

		if (count == record - 1) {

		    for (int i = 0; i < recordline.length; i++) {

			System.out.println(headers[i] + recordline[i]);
		    }
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
    
    public static Integer getRecordNumber() {
	
		
	String input = JOptionPane.showInputDialog("Enter record number you want to read: ");	
	
	
	if (input == null) {	    
	    return null;	
	
	} else {
	    
	     return Integer.valueOf(input);
	}
    
    }
    
    public static int getLineCount(String line) {
	
	 int linenumb = 0;
	    while(line != null) {
		
		linenumb++;
	    
	    }
    
	    return linenumb;
    }
}


