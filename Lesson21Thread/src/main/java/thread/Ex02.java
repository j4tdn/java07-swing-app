/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author qphan
 */
public class Ex02 {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());
        tasks.add(new Task());
        tasks.add(new Task());
        tasks.add(new Task());
        tasks.add(new Task());
        
        for (int i = 0 ; i < tasks.size(); i++) {
            Thread ti = new Thread(tasks.get(i), "t" + i);
            ti.start();
            
        }
    }
    
    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "is running.");
            } catch (InterruptedException ex) {
                Logger.getLogger(Ex02.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
