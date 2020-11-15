/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Asus
 */
public interface ConverterService {
    String convert(String input);
    String getResult(String input);
    
    int countWords(String input);
    String countDuplicateWords(String input);

    String switchTo(String input);

    boolean isAlphabet(String input);
        
    
    
}
