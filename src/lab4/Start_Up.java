package lab4;

/**
 *
 * @author Machi
 */
public class Start_Up {
    
     
    // testing the class
    public static void main(String[] args) {
	
	String inpath = "/temp/IOLab.txt";
	String outpath = "/temp/IOLabTest.txt";
	
	DataTransferService fileService = new DataTransferService(new TextFileReader(new CsvPipeDecoder()), 
		new TextWriter(new CsvCommaEncoder()) );
	
	
	
//	fileService.outputToConsole(fileService.inputFile(inpath));
	
	fileService.outputToConsole(fileService.inputFile(inpath));
	
	
	
	
	
    }
    
}
