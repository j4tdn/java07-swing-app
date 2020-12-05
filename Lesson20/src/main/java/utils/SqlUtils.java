package utils;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

public class SqlUtils {
	private SqlUtils() {
	}

	public static <T extends AutoCloseable> void close(T... closedElements) {
		Arrays.stream(closedElements).forEach(el -> {
			if (el != null) {
				try {
					el.close();
				} catch (Exception e) {
				}
			}
		});
	}

	public static String md5Hex(String password) {
		return "haha" + DigestUtils.md5Hex(password) + "huhu";
	}
}
