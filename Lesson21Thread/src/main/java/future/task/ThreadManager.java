/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package future.task;

import java.util.concurrent.Future;


/**
 *
 * @author Asus
 */
public interface ThreadManager {
    Future<?> safalyScheduleTask(int threadSize,Runnable task);
}
