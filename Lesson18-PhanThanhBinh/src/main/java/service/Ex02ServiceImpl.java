/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author OS
 */
public class Ex02ServiceImpl implements Ex02Service{

    @Override
    public int countInput(String input) {
        return input.split("\\s+").length;
    }

    @Override
    public String countDuplicateInput(String input) {
        String[] words = input.split("\\s+");
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String word: words) {
            if (map.containsKey(word)) {
                map.compute(word, (k, v) -> v + 1);
            } else {
                map.put(word, 1);
            }
        }
        String result = map.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue() + "\n")
                .collect(Collectors.joining());
        return result;
    }

    @Override
    public String changeToVietNameseWithOutAccents(String input) {
        String temp = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }
    
}
