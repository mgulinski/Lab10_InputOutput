/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Machi
 */
public class FileServiceManager {

    private FileInputStrategy input;
    private FileOutputStrategy output;
    private FileFormatService fileformat;

    public FileServiceManager(FileInputStrategy input, FileOutputStrategy output) {
	this.input = input;
	this.output = output;
    }
    
    /**
     * public getters and setters
     * @return 
     */
    public FileInputStrategy getInput() {
	return input;
    }

    public void setInput(FileInputStrategy input) {
	this.input = input;
    }

    public FileOutputStrategy getOutput() {
	return output;
    }

    public void setOutput(FileOutputStrategy output) {
	this.output = output;
    }

    public List< LinkedHashMap<String, String>> inputFile(String filePath) {
	return input.readInput(filePath);
    }

    public List<String> outputFile(List<Map<String, String>> decodedRecords) {
	return output.printOutput(decodedRecords);
	    }

    public void copyFile() {
    }

    
}
