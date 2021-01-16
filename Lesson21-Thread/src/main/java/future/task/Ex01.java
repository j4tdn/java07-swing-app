/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package future.task;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Ex01 {

    private static int threadSize = 4;
    private static ThreadManager threadManager;

    static {
        threadManager = new ThreadManagerImpl();
    }

    public static void main(String[] args) {
        FutureTask<List<String>> stringTask = new FutureTask<>(
                () -> Arrays.asList("a", "b", "c")
        );

        FutureTask<List<Integer>> integerTask = new FutureTask<>(
                () -> Arrays.asList(1, 2, 3)
        );

        runTasks(Arrays.asList(stringTask, integerTask));
        try {
            List<String> stringResult = stringTask.get();
            List<Integer> integerResult = integerTask.get();

            stringResult.forEach(System.out::println);
            integerResult.forEach(System.out::println);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ex01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Ex01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void runTasks(List<FutureTask<?>> tasks) {
        tasks.forEach(task -> threadManager.safelyScheduleTask(threadSize, task));
    }

}
