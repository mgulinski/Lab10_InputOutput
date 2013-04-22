package lab4;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Machi
 */
public interface FileInputStrategy {
    
    public abstract List< LinkedHashMap<String, String> >  readInput(String filePath);
    
}
