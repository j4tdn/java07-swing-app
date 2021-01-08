package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.cert.Extension;
import java.util.List;
import java.util.Random;


public class FileUtils {

	private FileUtils() {
	}

	public static boolean createFiles(File parent, int n, Extension... extensions) throws IOException {
		boolean isValue = false;

		for (int i = 1; i <= n; i++) {
			Extension ext = extensions[new Random().nextInt(extensions.length)];
			String child = i + "." + ext.getValue();
			File file = new File(parent, child);

			if (!file.exists()) {

				isValue = file.createNewFile();
				if (!isValue) {
					return false;
				}

			}
		}

		return isValue;

	}

	public static File createFile(String pathname) throws IOException {
		File file = new File(pathname);

		File parent = file.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;

	}

	
}
