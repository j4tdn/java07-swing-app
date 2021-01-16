/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Asus
 */
public enum IconQuestion {
    STAR("/images/qstar.png"),
    RECT("/images/qrect.png"),
    TRIANGLE("/images/qtriangle.png"),
    CIRCLE("/images/qcircle.png"),
    SPECIAL("/images/qspecial.png");

    private final String value;

    IconQuestion(String value) {
        this.value = value;
    }

    public String getVaue() {
        return this.value;

    }
    
}
