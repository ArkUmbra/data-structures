package com.arkumbra.ds.queue;

public interface Queue<T> {

  void enqueue(T t);
  T dequeue();
  boolean isEmpty();

}
