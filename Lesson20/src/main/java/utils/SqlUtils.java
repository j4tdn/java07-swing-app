/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.util.Arrays;
/**
 *
 * @author Asus
 */
public class SqlUtils {
    private SqlUtils() {
	}

	public static <T extends AutoCloseable> void close(@SuppressWarnings("unchecked") T... closedElements) {
		Arrays.stream(closedElements).forEach(e -> {
			if (e != null) {
				try {
					e.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}
    
}
