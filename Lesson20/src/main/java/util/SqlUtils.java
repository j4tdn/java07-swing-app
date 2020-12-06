package util;

import java.util.Arrays;

public class SqlUtils {

    private SqlUtils() {

    }

    public static <T extends AutoCloseable> void close(T... closedElement) {
        Arrays.stream(closedElement).forEach(element -> {
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
