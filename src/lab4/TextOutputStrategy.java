/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Machi
 */
public interface TextOutputStrategy {
    
    public abstract void outputData 
	    (List<LinkedHashMap <String, String>> decodedData, String filePath) throws IOException;
    
    public abstract void outputData 
	    (List< LinkedHashMap <String, String>> decodedData)throws IOException;
    
}
