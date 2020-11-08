/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author Asus
 */
public class ConverterServiceImpl implements ConverterService{

    @Override
    public String convert(String input) {
        
        
        
         return Pattern.compile("[\\s]+")
                 .splitAsStream(input)
                 .map(s->String.valueOf(s.charAt(0)))
                 .collect(Collectors.joining())
                 .toUpperCase();
        
    }

    @Override
    public String distin(String input) {
        return Pattern.compile("[,]+")
                .splitAsStream(input)
                .distinct()
                
                .map(s->String.valueOf(s.charAt(0)))
                .collect(Collectors.joining());
                
    }
    
}
