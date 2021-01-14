/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author qphan
 */
public class Ex01 {

    // process
    public static void main(String[] args) throws Exception {
        System.out.println("Thread main is running.");

        // separate thread
        Thread t00 = new Thread("t00") {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    System.out.println(Thread.currentThread().getName() + " is running");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ex01.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        t00.start();

        Task t01 = new Task("t01");
        t01.start();
        
        long start = System.currentTimeMillis();
        while(true) {
            if (System.currentTimeMillis() - start > 5000) {
                t01.stop();
                break;
            }
        }

        // Task t02 = new Task("t02");
        // t02.start();

        System.out.println("Thread main is finished.");
        
        Thread t03 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "is running");
            }
        }, "t03");
        t03.start();

    }

    static class Task extends Thread {

        public Task(String tname) {
            super(tname);
        }

        @Override
        public void run() {
            while(true) {
                System.out.println(Thread.currentThread().getName() + " is running.");
            }
        }
    }
}
