/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Machi
 */
public class TextWriter implements TextOutputStrategy {

    TextEncodingStrategy encoder;
    boolean append = false;

    public TextWriter(TextEncodingStrategy encoder) {
	this.encoder = encoder;

    }

    public TextWriter(TextEncodingStrategy encoder, boolean append) {
	this.encoder = encoder;
	this.append = append;
    }

    /**
     *
     * @param decodedData
     * @param filePath
     */
    @Override
    public void outputData(List< LinkedHashMap<String, String>> decodedData, String filePath) throws IOException {

	File data = new File(filePath);
	
	List<String> encodedRecordList = encoder.encodeData(decodedData);
	

	// Make sure we have permission to write this file to this path
	if (data.canWrite()) {
	    // Now write to that path...
	    // This is where we setup our streams (append = false means overwrite)
	    // new FileWriter() creates the file if doesn't exit
	    PrintWriter out = new PrintWriter(
		    new BufferedWriter(
		    new FileWriter(data, append)));

	   for (String enList: encodedRecordList) {
	       
	       out.println(enList);
	      
	    }

	    // print statements do actual work of writing data
	    // note that print statements work similar to Sytem.out.println,
	    // where data is converted to strings


	    out.close();  // be sure you close your streams when done!!
	}
    }

    @Override
    public void outputData(List< LinkedHashMap<String, String>> decodedData) {

	for (LinkedHashMap dd : decodedData) {

	    System.out.println(dd.toString());

	}

    }
}
