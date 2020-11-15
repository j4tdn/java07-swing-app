/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Arrays;

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
    public String getResult(String input) {
        String[] numbers = input.split(",");
		return Arrays.stream(numbers).filter(num -> Arrays.stream(numbers).filter(n -> (n.equals(num))).count() == 1)
				.map(s -> String.valueOf(s)).collect(Collectors.joining(","));
                
    }
    
}
