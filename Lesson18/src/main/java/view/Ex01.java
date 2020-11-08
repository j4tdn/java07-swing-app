/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;

/**
 *
 * @author khanh
 */

public class Ex01  {

    public Ex01() {
        
        initComponents();
        
        initEvent();
        
    }
    
    private void initComponents(){
        JFrame frame = new JFrame();
        frame.setSize(440, 220);
        frame.setVisible(true);
    }
    
        private void initEvent() {
    }
        
    public static void main(String[] args) {
        new Ex01();
    }


}
