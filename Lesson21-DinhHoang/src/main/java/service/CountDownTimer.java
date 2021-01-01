/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.swing.JLabel;

/**
 *
 * @author DangHoang
 */
public class CountDownTimer {

    private final JLabel lbTime;
    private boolean status;

    public CountDownTimer(JLabel lbTime) {
        this.lbTime = lbTime;
    }

    @SuppressWarnings("SleepWhileInLoop")
    public synchronized void countDownTimer(int time, boolean status) {
        while (status) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }

        for (int i = time; i >= 0; i--) {
            lbTime.setText(String.valueOf(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
        notify();
    }
}
