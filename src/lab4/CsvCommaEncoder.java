package lab4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * @author Machi
 */
public class CsvCommaEncoder implements TextEncodingStrategy {

    boolean createHeader = false;
    String[] headers = null;
    private static final String COMMA = ",";

//    String[] headers = {"First Name:\t", "Last Name:\t", "Street Addres:\t", "City:\t\t", "State:\t\t", "Zip:\t\t"};
    public CsvCommaEncoder() {
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
    public List<String> encodeData(List< LinkedHashMap<String, String>> decodedRecordList) {


	List<String> encodedRecordList = new ArrayList<>();


	for (LinkedHashMap records : decodedRecordList) {

	    Set<String> keys = records.keySet();
	    StringBuilder line = new StringBuilder();
	    
	     if (createHeader)  {		    
		   for (String key: keys ){
		       line.append(key);
		   } 
	   	}

	    for (String key : keys) {
		
		line.append(records.get(key)).append(COMMA);
	    }
	    line.deleteCharAt(line.length() - 1);
	    encodedRecordList.add(line + "\n");

	}


	return encodedRecordList;
    }
}
