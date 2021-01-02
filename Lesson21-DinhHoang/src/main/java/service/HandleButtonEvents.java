/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static utils.ComponentUtils.*;

/**
 *
 * @author DangHoang
 */
public class HandleButtonEvents {

    private final int lengthOfAnswer = 6;
    private final boolean[] btStatus = new boolean[lengthOfAnswer];
    private JButton[] buttons;
    private JButton selectedButton;
    private JLabel lbGif;
    private String answer;

    public HandleButtonEvents() {
    }

    private void createAnswerButtons(JPanel panel, JButton[] button, String result) {
        panel.removeAll();
        panel.repaint();
        String[] word = result.split("");
        for (int i = 0; i < word.length; i++) {
            button[i].setText("");
            panel.add(button[i]);
        }
        panel.revalidate();
    }

    private void questionDisplay(JLabel lbQuestion, String question) {
        lbQuestion.setText(question);
        lbQuestion.setBounds((920 - getPreWidth(lbQuestion)) / 2, 0,
                getPreWidth(lbQuestion), getPreHeight(lbQuestion));
    }

    public void processingQuestions(JPanel pnCenterTop, JPanel pnCenterLeft, JButton[] buttons,
            JLabel lbQuestion, String question, String answer, JLabel lbGif, Icon icon, JButton selectedButton) {
        this.buttons = buttons;
        this.selectedButton = selectedButton;
        this.answer = answer;
        this.lbGif = lbGif;
        this.lbGif.setBounds(350, 100, 180, 180);
        this.lbGif.setIcon(icon);
        Arrays.fill(btStatus, false);
        createAnswerButtons(pnCenterTop, buttons, answer);
        questionDisplay(lbQuestion, question);
    }

    public void buttonTextStatus(JButton button, int index) {
        for (int i = 0; i < 6; i++) {
            if (i == index) {
                setStatus(button, index);
                break;
            }
        }
    }

    private void setStatus(JButton button, int index) {
        if (btStatus[index]) {
            button.setText("");
            btStatus[index] = false;
        } else {
            button.setText(String.valueOf(answer.charAt(index)));
            btStatus[index] = true;
        }
    }

    public void handleButtonStartEvent(Icon icon) {
        if (selectedButton != null) {
            handleButtonResetEvent();
            lbGif.setBounds(350, 100, 180, 180);
            lbGif.setIcon(icon);
        }
    }

    public void handleButtonOpenAllEvent(Icon icon, boolean isButton) {
        Arrays.fill(btStatus, true);
        if (selectedButton != null) {
            if (isButton) {
                lbGif.setBounds(370, 100, 180, 180);
                lbGif.setIcon(icon);
            } else {
                lbGif.setBounds(235, 40, 450, 300);
                lbGif.setIcon(icon);
            }
            for (int i = 0; i < answer.length(); i++) {
                buttons[i].setText(String.valueOf(answer.charAt(i)));
            }
        }
    }

    public void handleButtonResetEvent() {
        if (selectedButton != null) {
            for (int i = 0; i < answer.length(); i++) {
                buttons[i].setText("");
            }
        }
    }
}
