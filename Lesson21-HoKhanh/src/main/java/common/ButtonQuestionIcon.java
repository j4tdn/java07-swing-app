/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author khanh
 */
public enum ButtonQuestionIcon {    
    STAR("/images/qstar.png"),
    RECT("/images/qrect.png"),
    TRIANGLE("/images/qtriangle.png"),
    CIRCLE("/images/qcircle.png"),
    SPECIAL("/images/qspecial.png");
    private final String path;
    private ButtonQuestionIcon(String path) {
        this.path =path;
    }
    public String getPath(){
        return path;
    }
    
    
    
}
