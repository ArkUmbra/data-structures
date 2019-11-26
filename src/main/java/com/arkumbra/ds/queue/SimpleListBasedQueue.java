package com.arkumbra.ds.queue;


import java.util.LinkedList;
import java.util.List;

public class SimpleListBasedQueue<T> implements Queue<T> {

  private List<T> elems = new LinkedList<>();
  private int tail = -1;
  // private int head // don't need head in this implementation as we are using .remove on list

  @Override
  public void enqueue(T t) {
    elems.add(t);
    tail++;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty");
    }

    // expensive?? - does an arraycopy underneath the hood
    T elem = elems.remove(0);
    tail--;
    return elem;
  }

  @Override
  public boolean isEmpty() {
    return tail < 0;
  }
}
