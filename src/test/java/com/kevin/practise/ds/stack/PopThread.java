package com.kevin.practise.ds.stack;

import java.util.function.Consumer;

public class PopThread<T> extends Thread {
    private IStack<T> stack;
    private int popTimes;
    private Consumer<T> consumer;

    public PopThread(IStack<T> stack, int popTimes, Consumer<T> consumer) {
        this.stack = stack;
        this.popTimes = popTimes;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < popTimes; i++) {
            T t = stack.pop();
            consumer.accept(t);
        }
    }
}
