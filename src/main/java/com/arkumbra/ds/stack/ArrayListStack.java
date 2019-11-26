package com.arkumbra.ds.stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStack<T> implements Stack<T> {

  private List<T> elements = new ArrayList<>();
  private int currentHead = -1;

  @Override
  public void push(T t) {
    currentHead++;
    elements.add(t);
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new RuntimeException("No elements exist");
    }
    T element = elements.get(currentHead);
    currentHead--;
    return element;
  }

  @Override
  public boolean isEmpty() {
    return currentHead < 0;
  }
}
