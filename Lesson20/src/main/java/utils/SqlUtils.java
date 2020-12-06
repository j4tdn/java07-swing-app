/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Arrays;

/**
 *
 * @author USER
 */
public class SqlUtils {

    private SqlUtils() {

    }

    public static <T extends AutoCloseable> void close(T... closedElements) {
        Arrays.stream(closedElements).forEach(element -> {
            if (element != null) {
                try {
                    element.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
