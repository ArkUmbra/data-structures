package com.arkumbra.ds.queue;

import com.arkumbra.ds.stack.ArrayListStack;
import com.arkumbra.ds.stack.Stack;

public class StackBasedQueueWithCheapEnqueue<T> implements Queue<T> {

  private Stack<T> main;
  private Stack<T> helper;

  public StackBasedQueueWithCheapEnqueue() {
    main = new ArrayListStack<>();
    helper = new ArrayListStack<>();
  }

  @Override
  public void enqueue(T t) {
    main.push(t);
  }

  @Override
  public T dequeue() {

    // flip the stack onto the helper stack
    while (! main.isEmpty()) {
      T elem = main.pop();
      helper.push(elem);
    }

    // answer is now at the end of helper stack
    T dequeued = helper.pop();

    // Flip the elements back onto the main array
    while (! helper.isEmpty()) {
      T elem = helper.pop();
      main.push(elem);
    }

    return dequeued;
  }

  @Override
  public boolean isEmpty() {
    return main.isEmpty();
  }
}
