package lab4;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Machi
 */
interface FileDecodingStrategy {
    
    public abstract List< LinkedHashMap <String, String> > decodeData(List<String> inputDataLines);
    
}
