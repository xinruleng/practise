package com.kevin.practise.utils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadHelper {
    /**
     * execute N runnables on N thread and wait all runnable completed
     *
     * @param runnables
     */
    public static void executeAndWaitComplete(Runnable... runnables) {
        final ExecutorService executor = Executors.newFixedThreadPool(runnables.length);

        for (Runnable runnable : runnables) {
            executor.execute(runnable);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void executeAndWaitComplete(List<Runnable> runnables) {
        executeAndWaitComplete(runnables.toArray(new Runnable[runnables.size()]));
    }

}
