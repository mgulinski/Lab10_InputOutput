/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Machi
 */
public class DataTransferService {

    private FileInputStrategy input;
    private TextOutputStrategy output;
    private FileFormatService fileformat;

    public DataTransferService(FileInputStrategy input, TextOutputStrategy output) {
	this.input = input;
	this.output = output;
	
    }

    /**
     * public getters and setters
     *
     * @return
     */
    public FileInputStrategy getInput() {
	return input;
    }

    public void setInput(FileInputStrategy input) {
	this.input = input;
    }

    public TextOutputStrategy getOutput() {
	return output;
    }

    public void setOutput(TextOutputStrategy output) {
	this.output = output;
    }

    
    
    
    public List< LinkedHashMap<String, String>> inputFile(String filePath) {
	return input.inputData(filePath);
    }

    public void outputToFile(List<LinkedHashMap<String, String>> decodedRecords, String filePath) {
	try {
	    output.outputData(decodedRecords, filePath);
	} catch (IOException ex) {
	    Logger.getLogger(DataTransferService.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void outputToConsole(List<LinkedHashMap<String, String>> decodedRecords) {
	try {
	    output.outputData(decodedRecords);
	} catch (IOException ex) {
	    Logger.getLogger(DataTransferService.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void copyFile() {
    }

//    // main method for testing
//    public static void main(String[] args) {
//	
//	String path = "/temp/IOLab.txt";
//
//	FileFormatService formatter = new FileFormatService(new CsvPipeDecoder(), new CsvPipeEncoder());
//
//	DataTransferService fileService = new DataTransferService(new TextFileReader(new CsvPipeDecoder()), 
//		new TextWriter(new CsvPipeEncoder()));
//	
//		
//	fileService.outputToConsole(fileService.inputFile(path));
//
//    }
}
