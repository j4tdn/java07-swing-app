/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author ADMIN
 */
public class Ex03 {
    public static void main(String[] args) {
        ExecutorService service=Executors.newFixedThreadPool(4);
        for(int i=0;i<10;i++){
            service.execute(new Task());
            // Future<String> future = service.submit(()->"");
        }
        
        service.shutdown();
    }
    
    
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
