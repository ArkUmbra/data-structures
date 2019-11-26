package com.arkumbra.ds.stack;

public class SimpleFixedArrayStack<T> implements Stack<T> {

  private Object[] elements;
  private int currentHead = -1;
  private int maxSize;

  public SimpleFixedArrayStack(int size) {
    this.maxSize = size;
    this.elements = new Object[size];
  }

  /*
    Complexity O(1)
  */
  @Override
  public void push(T t) {
    currentHead++;
    if (currentHead == maxSize) {
      throw new IndexOutOfBoundsException("Too many elements");
    }
    elements[currentHead] = t;
  }

  /*
    Complexity O(1)
  */
  @SuppressWarnings("unchecked")
  @Override
  public T pop() {
    if (isEmpty()) {
      throw new RuntimeException("No elements exist");
    }
    T element = (T)elements[currentHead];
    currentHead--;
    return element;
  }

  /*
    Complexity O(1)
  */
  @Override
  public boolean isEmpty() {
    return (currentHead < 0);
  }

}
