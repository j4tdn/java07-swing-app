/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author ADMIN
 */
public class TruncateServiceImpl implements TruncateService {

    @Override
    public String truncate(String input) {

        List<String> in = Pattern.compile("[,\\s]+").splitAsStream(input.trim()).sorted().collect(Collectors.toList());
        List<String> out = new ArrayList<>();

        for (int i = 0; i < in.size(); i++) {
            int count = 0;
            for (int j = 0; j < in.size(); j++) {
                if (in.get(i).equals(in.get(j))) {
                    count++;
                }
            }
            if (count == 1) {
                out.add(in.get(i));
            }
        }
        String result = out.stream().collect(Collectors.joining(","));

        return result;
    }

}
