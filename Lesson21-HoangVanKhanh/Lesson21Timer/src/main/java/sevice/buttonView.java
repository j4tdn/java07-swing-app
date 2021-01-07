/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevice;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class buttonView {
    private  JButton[] btAdd = new JButton[6];
    private  String answer;
    private  JPanel pnView;

    public buttonView() {
    }
    
    
    public void getButton(JButton[] btAdd,String answer,JPanel pnView){
        this.btAdd = btAdd;
        this.answer = answer;
        this.pnView = pnView;
        pnView.removeAll();
        pnView.repaint();
        for(int i=0;i<answer.length();i++){
            
            pnView.add(btAdd[i]);
            btAdd[i].setText("");
            
        }
        pnView.revalidate();
        
        
    }
    public void getButtonview(int index){
            btAdd[index].setText(String.valueOf(answer.charAt(index)));
            
        
        
        
        
    }
    public void openAnswer(){
        for(int i=0;i<answer.length();i++){
            btAdd[i].setText(String.valueOf(answer.charAt(i)));
        }
    }
    public void deleteAnswer(){
        for(int i=0;i<answer.length();i++){
            btAdd[i].setText("");
        }
    }
    
}
