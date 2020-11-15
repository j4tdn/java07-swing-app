/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class ConverterServiceImpl implements ConverterService {

    @Override
    public String convertToUnsignedString(String input) {
        try {
            String temp = Normalizer.normalize(input, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
