package com.kevin.practise.ds.stack;

import com.kevin.practise.utils.ThreadHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;

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

    @Test
    public void should_stack_increase_when_threads_push_into_given_stack() {
        //given
        IStack<Integer> stack = new MyStack<>();

        //when
        final int THREAD_COUNT = 5;
        final int MILLION_TIMES = 1_000_000;
        PushThread[] threads = new PushThread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int offset = i;
            threads[i] = new PushThread(stack, MILLION_TIMES, new Function<Integer, Integer>() {
                @Override
                public Integer apply(Integer index) {
                    return offset * THREAD_COUNT + index;
                }
            });
        }
        ThreadHelper.executeAndWaitComplete(threads);

        //then
        Assert.assertEquals(THREAD_COUNT * MILLION_TIMES, stack.size());
    }

    @Test
    public void should_stack_decrease_when_threads_pop_from_given_stack() {
        //given
        IStack<Integer> stack = new MyStack<>();
        final int THREAD_COUNT = 5;
        final int MILLION_TIMES = 1_000_000;
        for (int i = 0; i < THREAD_COUNT; i++) {
            for (int j = 0; j < MILLION_TIMES; j++) {
                stack.push(i * MILLION_TIMES + j);
            }
        }

        //when
        PopThread[] threads = new PopThread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new PopThread(stack, MILLION_TIMES, new Consumer<Integer>() {
                @Override
                public void accept(Integer o) {

                }
            });
        }
        ThreadHelper.executeAndWaitComplete(threads);

        //then
        Assert.assertEquals(0, stack.size());
    }
}