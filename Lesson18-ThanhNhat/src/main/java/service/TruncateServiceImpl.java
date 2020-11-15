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
 * @author ADMIN
 */
public class TruncateServiceImpl implements TruncateService {

    @Override
    public String truncate(String input) {
        int[] numbers = Pattern.compile("[,\\s]+")
                .splitAsStream(input)
                .mapToInt(Integer::parseInt).toArray();

        int[] result = new int[numbers.length];
        int index = 0;

        for (int number : numbers) {
            if (isUnique(numbers, number)) {
                result[index++] = number;
            }
        }

        for (int out = 0; out < numbers.length; out++) {
            int count = 1;
            for (int in = 0; in < numbers.length; in++) {
                if ((in != out) && (numbers[in] == numbers[out])) {
                    count++;
                    break;
                }
            }
            if (count == 1) {
                result[index++] = numbers[out];
            }
        }

        return Arrays.stream(Arrays.copyOfRange(result, 0, index))
                .distinct().mapToObj(i -> ((Integer) i).toString())
                .collect(Collectors.joining(", "));
    }

    private static boolean isUnique(int numbers[], int input) {
        int count = 0;
        for (int number : numbers) {
            if (number == input) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
