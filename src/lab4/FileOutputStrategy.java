/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.List;

/**
 *
 * @author Machi
 */
public interface FileOutputStrategy {
    
    public abstract void printOutput(List<String[]> records);
}
