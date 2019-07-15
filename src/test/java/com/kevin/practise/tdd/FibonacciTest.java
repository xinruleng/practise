package com.kevin.practise.tdd;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {

    @Test
    public void should_throw_exception_given_index_below_1() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.calculate(0));
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.calculate(-1));
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.calculate(-5));
    }

    @Test
    public void should_throw_exception_given_index_above() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.calculate(51));
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.calculate(100));
    }

    @Test
    public void should_get_1_given_index_1_or_2() {
        assertEquals(1, Fibonacci.calculate(1));
        assertEquals(1, Fibonacci.calculate(2));
    }

    @Test
    public void should_get_correct_number_given_index_between_3_or_50() {
        assertEquals(2, Fibonacci.calculate(3));
        assertEquals(5, Fibonacci.calculate(5));
        assertEquals(55, Fibonacci.calculate(10));
    }

    @Test
    public void should_get_12586269025_given_index_50() {
        assertEquals(12586269025L, Fibonacci.calculate(50));

    }
}
