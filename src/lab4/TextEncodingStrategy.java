package lab4;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Machi
 */
interface TextEncodingStrategy {
    
    public abstract List<String> encodeData (List< LinkedHashMap<String, String>> decodedRecordList);
    
}
