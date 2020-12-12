/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author ADMIN
 */
public class ImageUtils {

    private ImageUtils() {

    }

    public static Icon getIcon(String path, int width, int height) {
        if (path == null || path.isEmpty()) {
            path = "image_upload"+File.separator+"default.jpg";
        }
        Image image = new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    System.out.println(path);

        return new ImageIcon(image);
    }
}
