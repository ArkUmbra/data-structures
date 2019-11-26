package com.arkumbra.ds.stack;

/**
 * FILO first in last out
 *
 *
 * Applications -> reverse a word
 *
 * Terms ->
 *    Underflow =
 *    Overflow =
 *
 * @param <T>
 */
public interface Stack<T> {

  void push(T t);
  T pop();

  boolean isEmpty();

}
