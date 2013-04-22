package lab4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * @author Machi
 */
public class CsvDecodingStrategy {

    boolean hasHeader = false;
    private static final String COMMA = ",";
    private static final String PIPE = "\\|";
//    String[] headers = {"First Name:\t", "Last Name:\t", "Street Addres:\t", "City:\t\t", "State:\t\t", "Zip:\t\t"};

    public CsvDecodingStrategy() {
    }

    public boolean getHasHeader() {
	return hasHeader;
    }

    public void setHasHeader(boolean hasHeader) {
	this.hasHeader = hasHeader;
    }

    /**
     * This method takes List of record lines that are separated by comma as
     * argument.
     *
     * @param inputDataLines
     * @return
     */
    public List< LinkedHashMap<String, String>> decodeData(List<String> inputDataLines) {

	List< LinkedHashMap<String, String>> decodedRecordList =
		new ArrayList< LinkedHashMap<String, String>>();

	String[] headers = null;

	// let's check if there is a header it would be the first line or records;
	// if hasHeader = true then we build array of headers
	if (hasHeader) {
	    headers = inputDataLines.get(0).split(PIPE);
	}

	for (int row = 0; row < inputDataLines.size(); row++) {

	    if ((hasHeader) && (row == 0)) {
		row++;
	    }

	    String[] fields = inputDataLines.get(row).split(PIPE);

	    LinkedHashMap<String, String> decodedRecord = new LinkedHashMap<>();
	    int recordNum = 0;
	    for (int col = 0; col < fields.length; col++) {

		if (hasHeader) {
		    decodedRecord.put(headers[col], fields[col]);
		} else {
		    decodedRecord.put(String.valueOf(recordNum), fields[col]);
		    recordNum++;
		}
	    }

	    decodedRecordList.add(decodedRecord);
	}

	return decodedRecordList;
    }

    // public method to test the class
    public static void main(String[] args) {


	CsvDecodingStrategy csvdeco = new CsvDecodingStrategy();

//	System.out.println(cvsde.getHasHeader());

	List<String> inputRecordLines = new ArrayList<String>();

	inputRecordLines.add("FIRST NAME|LAST NAME|STREET ADDRESS|CITY|STATE|ZIP");
	inputRecordLines.add("Machi|Gulinski|5367 Eastway|Greendale|WI|53129");
	inputRecordLines.add("Ola|Druzny|5467 Blue St.|Milwaukee|WI|53209");
	inputRecordLines.add("Les|Klimek|919 St. Paul St.|Wauwatosa|WI|53217");

	csvdeco.setHasHeader(true);

	List< LinkedHashMap<String, String>> decodedData = new ArrayList< LinkedHashMap<String, String>>();

	decodedData = csvdeco.decodeData(inputRecordLines);


	for (LinkedHashMap r : decodedData) {

	    Set<String> keys = r.keySet();

	    for (String key : keys) {

//	    String record = r.get(key).toString();
		System.out.println(key + ": " + r.get(key).toString());
	    }

//	    System.out.println(r.keySet() + ": " + r.entrySet());
	}

    }
}
