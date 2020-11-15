/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author OS
 */
public class Ex01ServiceImpl implements Ex01Service{

    @Override
    public String getUniqueNumbers(String input) {
        String[] words = input.split(",[\\s]{0,}");
        Map<Integer, Integer> map = new HashMap<>();
        for (String word: words) {
            Integer key;
            try {
                key = Integer.parseInt(word);
            } catch (Exception e) {
                return "Error";
            }
            if (map.containsKey(key)) {
                map.compute(key, (k, v) -> v + 1);
            } else {
                map.put(key, 1);
            }
        }
        String result = map.entrySet().stream()
                .filter(entry -> entry.getValue().equals(1))
                .map(entry -> entry.getKey().toString())
                .collect(Collectors.joining(", "));
        return result;
    }
    
}
