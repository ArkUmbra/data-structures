package com.arkumbra.ds.heap;

import java.util.PriorityQueue;

/**
 * This came up on a botched PayPay interview question. Hence implementing here with the
 * knowledge I have since gained...
 */
public class MedianHeap implements Heap<Integer> {
  private static final boolean DEBUG = true;

  // lowest half. prioritised to give highest
  private PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2)-> o2-o1);
  // highest half. prioritised to give lowest
  private PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2)-> o1-o2);


  @Override
  public void add(Integer t) {
    if (isEmpty()) {
      min.add(t);
    } else {
      float median = getMedian();
      if (t >= median) {
        max.add(t);
      } else {
        min.add(t);
      }

      fixOrdering();
    }

    if (!DEBUG) {
      return;
    }

    // show sorted order
    System.out.println("Min queue");
    for (Integer num: min) {
      System.out.println(num);
    }

    System.out.println("Max queue");
    for (Integer num: max) {
      System.out.println(num);
    }

    System.out.println();
  }

  @Override
  public Integer get() {
    return null;
  }

  @Override
  public boolean isEmpty() {
    return max.isEmpty() && min.isEmpty();
  }

  /*
    If there an odd number of elements, return the middle element
    If there an even number of elements, return the mean of the two elements in the middle
   */
  public float getMedian() {

    if (isEmpty()) {
      return 0f;
    } else if (max.size() == min.size()) {
      return (max.peek() + min.peek()) / 2;
    } else {
      if (max.size() > min.size()) {
        return max.peek();
      } else {
        return min.peek();
      }
    }
  }

  private void fixOrdering() {
    int maxSize = max.size();
    int minSize = min.size();

    if (Math.abs(maxSize - minSize) > 1) {
      if (maxSize > minSize) {
        min.add(max.poll());
      } else {
        max.add(min.poll());
      }
    }
  }


}
