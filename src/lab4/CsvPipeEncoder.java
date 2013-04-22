package lab4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * @author Machi
 */
public class CsvPipeEncoder implements TextEncodingStrategy {

    boolean createHeader = false;
    private static final String COMMA = ",";
    private static final String PIPE = "|";
//    String[] headers = {"First Name:\t", "Last Name:\t", "Street Addres:\t", "City:\t\t", "State:\t\t", "Zip:\t\t"};

    public CsvPipeEncoder() {
    }

    public boolean getCreateHeader() {
	return createHeader;
    }

    public void setCreateHeader(boolean createHeader) {
	this.createHeader = createHeader;
    }

    /**
     * This method takes List of record lines that are separated by comma as
     * argument.
     *
     * @param inputDataLines
     * @return
     */
    @Override
    public List<String> encodeData(List< LinkedHashMap<String, String>> decodedRecordList) {

	List<String> encodedRecordList = new ArrayList<>();

	// let's check if there is a header it would be the first line or records;
	// if hasHeader = true then we build array of headers
//	if (createHeader) {
//	    headers = inputDataLines.get(0).split(PIPE);
//	}

	
	for (LinkedHashMap records : decodedRecordList) {

	    Set<String> keys = records.keySet();
	    StringBuilder line = new StringBuilder();

	    
	    for (String key : keys) {

		line.append(records.get(key)).append(PIPE);
	    }
	    
	    line.deleteCharAt(line.length() - 1);
	    encodedRecordList.add(line + "\n");
	    
	}


	return encodedRecordList;
    }

    
//    
//    
//    // public method to test the class
//    public static void main(String[] args) {
//
//	CsvPipeDecoder csvDeco = new CsvPipeDecoder();
//
////	System.out.println(cvsde.getHasHeader());
//
//	List<String> inputRecordLines = new ArrayList<String>();
//
//	inputRecordLines.add("FIRST NAME|LAST NAME|STREET ADDRESS|CITY|STATE|ZIP");
//	inputRecordLines.add("Machi|Gulinski|5367 Eastway|Greendale|WI|53129");
//	inputRecordLines.add("Ola|Druzny|5467 Blue St.|Milwaukee|WI|53209");
//	inputRecordLines.add("Les|Klimek|919 St. Paul St.|Wauwatosa|WI|53217");
//
//	csvDeco.setHasHeader(true);
//
//	List< LinkedHashMap<String, String>> decodedData = new ArrayList< >();
//
//	decodedData = csvDeco.decodeData(inputRecordLines);
//
//
//	for (LinkedHashMap r : decodedData) {
//
//	    Set<String> keys = r.keySet();
//
//	    for (String key : keys) {
//
////	    String record = r.get(key).toString();
//		System.out.println(key + ": " + r.get(key).toString());
//	    }
//	}
//
//
//	CsvPipeEncoder csvEnco = new CsvPipeEncoder();
//
//	for (String ln : csvEnco.encodeData(decodedData)) {
//	    
//	    System.out.println(ln); 
//	}
//    }
}
