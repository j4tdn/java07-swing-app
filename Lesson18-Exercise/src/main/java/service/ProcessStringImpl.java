/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.text.Normalizer;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author ADMIN
 */
public class ProcessStringImpl implements ProcessString {

    public static int size;

    @Override
    public int count(String input) {

        return Pattern.compile("[,\\s]+").splitAsStream(input).collect(Collectors.toList()).size();

    }

    @Override
    public String countDuplicate(String input) {
        List<String> ls = Pattern.compile("[,\\s]+").splitAsStream(input).collect(Collectors.toList());
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for (int i = 0; i < ls.size(); i++) {
            addElement(map, ls.get(i));
        }
        String result = "";
        for (String key : map.keySet()) {
            result += key + " xuất hiện " + map.get(key) + "lần .\n";
        }
        return result;
    }

    public static void addElement(Map<String, Integer> map, String element) {
        if (map.containsKey(element)) {
            int count = map.get(element) + 1;
            map.put(element, count);
        } else {
            map.put(element, 1);
        }
        size = map.size();
    }

    @Override
    public String changeVietnamese(String input) {
        String temp = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

}
