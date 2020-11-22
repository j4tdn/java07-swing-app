/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Arrays;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import utils.VN;



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

    @Override
    public int countWords(String input) {
        return input.split("[ ]+").length;
    }

    @Override
    public String countDuplicateWords(String input) {
        Map<String, Long> map = Pattern.compile("[ ]+").splitAsStream(input)
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		String result = "";
		for (Entry<String, Long> entry : map.entrySet()) {
			result += entry.getKey() + " : " + entry.getValue() + " lần.\n";
		}
		return result;
    }

    @Override
    public String switchTo(String input) {
        String result = "";
		for (int i = 0; i < input.length(); i++) {
			if (!" ".equals(String.valueOf(input.charAt(i)))) {
				result += VN.changeTo(String.valueOf(input.charAt(i)));
			} else {
				result += " ";
			}
		}
		return result;
    }

    @Override
    public boolean isAlphabet(String input) {
        String str = "0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~}";
		for (int i = 0; i < input.length(); i++) {
			if (!" ".equals(String.valueOf(input.charAt(i))) && str.contains(String.valueOf(input.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
    }
    

