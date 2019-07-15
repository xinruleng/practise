package com.kevin.practise.tdd;

public class Fibonacci {
    public static long calculate(int index) {
        if (index < 1 || index > 50) {
            throw new IllegalArgumentException();
        }
        if (index == 1 || index == 2) {
            return 1;
        }

        long first = 1;
        long second = 1;
        for (int i = 3; i <= index; i++) {
            long tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }
}
