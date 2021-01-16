/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.lang.System.Logger;

/**
 *
 * @author ADMIN
 */
public class Ex01 {
    private static int number=0;
    public static void main(String[] args) {
        System.out.println("Thread main is running");

        // separate thread
        Thread t00 = new Thread("t00") {
            @Override
            public void run() {
                try {
                    number++;
                    sleep(3000);
                    System.out.println(Thread.currentThread().getName() + " is running");
                } catch (InterruptedException ex) {

                }
            }

        };
        t00.start();

        Task t01 = new Task("t01");
        t01.start();

        long start = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - start > 10000) {
                // t01.stop();
                t01.suspend();
                break;
            }
        }

        System.out.println("Thread main is finished");

        Thread t03 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        }, "t03");
        t03.start();
    }

    static class Task extends Thread {

        public Task(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                number++;
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        }

    }
}
