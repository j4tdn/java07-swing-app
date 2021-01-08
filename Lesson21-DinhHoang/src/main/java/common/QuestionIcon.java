/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author DangHoang
 */
public enum QuestionIcon {

    QSTAR("/images/imageButtons/qstar.png"),
    QRECT("/images/imageButtons/qrect.png"),
    QTRIANGLE("/images/imageButtons/qtriangle.png"),
    QCIRCLE("/images/imageButtons/qcircle.png"),
    QSPECIAL("/images/imageButtons/qspecial.png");

    private final String value;

    QuestionIcon(String value) {
        this.value = value;
    }

    public String getQuestionIcon() {
        return value;
    }
}
