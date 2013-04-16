package lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author Machi
 */
public class Lab_IO_part21 {

    private static boolean isNumeric = true;

    public static void main(String[] args) {
	Integer recNum = -1;
	do {
	    try {
		recNum = Lab_IO_part21.getRecordNumber();

		if (recNum == null) {
		    System.exit(0);
		}
		isNumeric = true;

	    } catch (NumberFormatException nfe) {
		isNumeric = false;
	    }
	} while (!isNumeric);


//	File data = new File(File.separatorChar + "temp" + File.separatorChar 
//                        + "test.txt");

	File data = new File("/temp/IOLab.txt");
	String[] headers = {"First Name:\t", "Last Name:\t", "Street Addres:\t", "City:\t\t", "State:\t\t", "Zip:\t\t"};

	BufferedReader in = null;
	try {
	    in = new BufferedReader(new FileReader(data));
	    String line = in.readLine();

	    int count = 0;
	    while (line != null) {

		String[] recordline = line.split("\\|");

		// user choice of line starts with 1 so to get the first record 0 
		// we need to substract 1 from input value
		if (count == recNum - 1) {

		    for (int i = 0; i < recordline.length; i++) {
			
//			if (headers[i].equals("City:\t\t")) {
//			    System.out.println(headers[i] + recordline[i]);
//			}
			if (headers[i].equals(headers[3])) {

			    System.out.println(headers[i] + recordline[i]);
			}
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

    private static Integer getRecordNumber() throws NumberFormatException {
	String input = JOptionPane.showInputDialog("Please enter a record number:");

	if (input == null) {
	    return null;

	} else {
	    //parse to integer
	    return Integer.valueOf(input);
	}
    }
}
