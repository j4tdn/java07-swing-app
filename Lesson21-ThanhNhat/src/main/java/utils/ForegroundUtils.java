/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class ForegroundUtils {
    private ForegroundUtils(){
        
    }
    
    public static void setHiddenForeground(JPanel panel){
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setForeground(new Color(0,0,0,0));
            }
        }
    }
    
    public static void setAppearedForeground(JPanel panel){
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button.setForeground(Color.black);
                    }
                });
            }
        }
    }
    
}
