package com.kevin.practise.ds.stack;

import org.junit.Assert;
import org.junit.Test;

public class MyStackTest {
    @Test
    public void should_stack_increase_when_push_into_given_stack() {
        //given
        IStack<Integer> stack = new MyStack<>();

        //when
        stack.push(1);

        //then
        Assert.assertEquals(1, stack.size());

    }

    @Test
    public void should_stack_decrease_when_pop_from_given_stack() {
        //given
        final Integer input = 1;

        IStack<Integer> stack = new MyStack<>();
        stack.push(input);

        //when
        Integer output = stack.pop();

        //then
        Assert.assertEquals(0, stack.size());
        Assert.assertEquals(input, output);
    }

    @Test
    public void should_stack_not_change_when_peek_from_given_stack() {
        //given
        final Integer input = 1;

        IStack<Integer> stack = new MyStack<>();
        stack.push(input);

        //when
        Integer output = stack.peek();

        //then
        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(input, output);
    }

    @Test
    public void should_stack_is_empty_when_init_from_empty_stack() {
        //given
        IStack<Integer> stack = new MyStack<>();

        //when

        //then
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void should_stack_is_not_empty_when_push_into_given_stack() {
        //given
        IStack<Integer> stack = new MyStack<>();

        //when
        stack.push(1);

        //then
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void should_stack_is_empty_when_pop_from_given_stack() {
        //given
        IStack<Integer> stack = new MyStack<>();
        stack.push(1);

        //when
        stack.pop();

        //then
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void should_stack_is_not_empty_when_peek_from_given_stack() {
        //given
        IStack<Integer> stack = new MyStack<>();
        stack.push(1);

        //when
        stack.peek();

        //then
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void should_stack_increase_when_push_null_into_given_stack() {
        //given
        IStack<Integer> stack = new MyStack<>();

        //when
        stack.push(null);

        //then
        Assert.assertEquals(1, stack.size());
    }

    @Test
    public void should_stack_pop_null_when_pop_from_empty_stack() {
        //given
        IStack<Integer> stack = new MyStack<>();

        //when
        Integer output = stack.pop();

        //then
        Assert.assertNull(output);
    }

    @Test
    public void should_stack_peek_null_when_peek_from_empty_stack() {
        //given
        IStack<Integer> stack = new MyStack<>();

        //when
        Integer output = stack.peek();

        //then
        Assert.assertNull(output);
    }

    @Test
    public void should_stack_pop_when_pop_from_stack() {
        //given
        IStack<Integer> stack = new MyStack<>();
        final int TEST_COUNT = 10;
        Integer[] expect = new Integer[TEST_COUNT];
        for (int i = 0; i < expect.length; i++) {
            expect[i] = i;
            stack.push(i);
        }

        //when
        Integer[] act = new Integer[TEST_COUNT];
        int i = act.length;
        while (!stack.isEmpty()) {
            act[--i] = stack.pop();
        }

        //then
        Assert.assertArrayEquals(expect, act);
    }
}