/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Machi
 */
public interface FileOutputStrategy {
    
    public abstract List<String> printOutput(List<Map <String, String>> decodedData, String filePath);
}
