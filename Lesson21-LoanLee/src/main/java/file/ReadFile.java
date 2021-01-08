/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

/**
 *
 * @author ADMIN
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import utils.FileUtils;

public class ReadFile {

    public List<String> read(String topic) throws IOException {
        String pathname = "JAVA07" + File.separator + topic
                + ".txt";
        File file = FileUtils.createFile(pathname);
        List<String> result = Files.readAllLines(file.toPath());
        return result;
    }

}
