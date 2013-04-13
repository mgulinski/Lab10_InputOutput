package lab2;

import lab1.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Machi
 */
public class Lab_IO_part2 {

    public static void main(String[] args) {
	
	
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter record number you want to read: ");	
	int record = input.nextInt();
	

//	File data = new File(File.separatorChar + "temp" + File.separatorChar 
//                        + "test.txt");

	File data = new File("/temp/IOLab.txt");
	String[] headers = { "First Name:\t", "Last Name:\t", "Street Addres:\t", "City:\t\t", "State:\t\t", "Zip:\t\t" };

	BufferedReader in = null;
	try {
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
}
