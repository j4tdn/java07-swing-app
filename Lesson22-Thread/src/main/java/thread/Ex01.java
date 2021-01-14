/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author DangHoang
 */
public class Ex01 {

    public static void main(String[] args) {
        System.out.println("Thread main is running!");

//        Separate thread
        Thread t00 = new Thread("t00") {
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException ex) {
                }
                System.out.println(Thread.currentThread().getName());
            }
        };
        t00.start();

        Task t01 = new Task("t01");
        long start = System.currentTimeMillis();
        t01.start();
        while (true) {
            if (System.currentTimeMillis() - start > 5000) {
                t01.stop();
                break;
            }
        }

//        Task t02 = new Task();
//        t02.start();
        System.out.println("Thread main is finished!");
    }

    static class Task extends Thread {

        public Task(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is running!");
            }
        }
    }
}
