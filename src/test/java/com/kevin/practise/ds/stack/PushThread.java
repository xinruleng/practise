package com.kevin.practise.ds.stack;

import java.util.function.Function;

public class PushThread<T> extends Thread {
    private IStack<T> stack;
    private int pushTimes;
    private Function<Integer, T> function;

    public PushThread(IStack<T> stack, int pushTimes, Function<Integer, T> function) {
        this.stack = stack;
        this.pushTimes = pushTimes;
        this.function = function;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < pushTimes; i++) {
            stack.push(function.apply(i));
        }
    }
}
