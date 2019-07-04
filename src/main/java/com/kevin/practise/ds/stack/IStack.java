package com.kevin.practise.ds.stack;

public interface IStack<T> {
    void push(T element);

    int size();

    T pop();

    T peek();

    boolean isEmpty();
}