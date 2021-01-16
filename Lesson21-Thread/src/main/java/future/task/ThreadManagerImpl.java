/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package future.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *
 * @author ADMIN
 */
public class ThreadManagerImpl implements ThreadManager{

    @Override
    public Future<?> safelyScheduleTask(int threadSize, Runnable task) {
        ExecutorService service=Executors.newFixedThreadPool(threadSize);
        return service.submit(()->task.run());
    }
    
}
