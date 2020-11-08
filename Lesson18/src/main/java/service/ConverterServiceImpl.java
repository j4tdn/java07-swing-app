/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author OS
 */
public class ConverterServiceImpl implements ConverterService{

    @Override
    public String convert(String input) {
        return Pattern.compile("[\\s]+")
                .splitAsStream(input)
                .map(word -> String.valueOf(word.charAt(0)))
                .collect(Collectors.joining())
                .toUpperCase();
    }
    
}
