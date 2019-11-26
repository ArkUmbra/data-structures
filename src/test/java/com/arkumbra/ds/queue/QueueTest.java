package com.arkumbra.ds.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

  private List<Queue<Integer>> implementations;

  @Before
  public void setUp() {
    implementations = new ArrayList<>();

    // add implementations
    implementations.add(new SimpleListBasedQueue<>());
  }

  @Test
  public void testEnqueueDequeue() {
    for (Queue<Integer> q : implementations) {
      System.out.println("Testing " + q.getClass().getSimpleName());
      doEnqueueDequeue(q);
    }
  }

  private void doEnqueueDequeue(Queue<Integer> queue) {
    List<Integer> allElems = new ArrayList<>();

    assertTrue(queue.isEmpty());

    // Add a bunch of elements
    Random r = new Random();
    for (int i = 0; i < 100000; i++) {
      int num = r.nextInt();
      allElems.add(num);

      queue.enqueue(num);
      assertFalse(queue.isEmpty());
    }

    for (Integer i : allElems) {
      assertFalse(queue.isEmpty());
      Integer de = queue.dequeue();
      assertEquals(i, de);
    }

    assertTrue(queue.isEmpty());
  }



}
