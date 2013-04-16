/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Machi
 */
public class FileServiceManager {

    private FileInputStrategy input;
    private FileOutputStrategy output;
    private List records = new ArrayList();

    public FileServiceManager(FileInputStrategy input, FileOutputStrategy output) {
	this.input = input;
	this.output = output;
    }    
    
    public List<List<String>> inputFile() {	
	return input.readInput();    
    }
    
    public void outputFile(List<List<String>> records) {
	output.printOutput(input.readInput());
    
    
    }
    
    public void copyFile () {
	
	
    
    
    }
    
      

    public static void main(String[] args) {
	
	
	FileServiceManager filemanager = new FileServiceManager(new PSVFileReadingStrategy(), new PSVFileWritingStrategy());
    }
}
