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
 * @author ADMIN
 */
public class Ex02 {
    public static void main(String[] args) {
        List<Task> tasks=new ArrayList<>();
        
        tasks.add(new Task());
        tasks.add(new Task());
        tasks.add(new Task());
        tasks.add(new Task());
        tasks.add(new Task());
        
        for (int i=0;i<tasks.size();i++){
            Thread ti=new Thread(tasks.get(i),"t"+i);
            ti.start();
        }
        
        //Thread t00=new Thread(new Task(),"t00");
        //t00.start();
    }
    
    // extend thread thi khi goi phai new thread roi start
    // implement runnable thi khi goi ko start dc ma phai new thread roi overide lai ham run
    static class Task implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" is running");
            } catch (InterruptedException ex) {
                
            }
        }
        
    }
}
