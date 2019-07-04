package com.kevin.practise.ds.stack;

public class MyStack<E> implements IStack<E> {
    class Node {
        E data;
        Node next;

        public Node(E element, Node next) {
            this.data = element;
            this.next = next;
        }
    }

    private Node top;
    private int size;

    public MyStack() {
    }

    @Override
    public synchronized void push(E element) {
        Node node = new Node(element, top);
        top = node;
        size++;
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized E pop() {
        if (top == null) {
            return null;
        }
        E e = top.data;
        top = top.next;
        size--;
        return e;
    }

    @Override
    public synchronized E peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    @Override
    public synchronized boolean isEmpty() {
        return size == 0;
    }
}
