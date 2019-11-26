package com.arkumbra.ds.heap;

public interface Heap<T> {

  void add(T t);
  T get();
  boolean isEmpty();
}
