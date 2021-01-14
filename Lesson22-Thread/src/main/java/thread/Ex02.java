/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DangHoang
 */
public class Ex02 {

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());
        tasks.add(new Task());
        tasks.add(new Task());
        tasks.add(new Task());
        tasks.add(new Task());

        for (int i = 0; i < tasks.size(); i++) {
            Thread t = new Thread(tasks.get(i), "t1");
            t.start();
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + " is running!");
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}
