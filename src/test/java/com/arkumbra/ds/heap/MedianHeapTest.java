package com.arkumbra.ds.heap;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MedianHeapTest {

  private MedianHeap heap;

  @Before
  public void setUp() {
    heap = new MedianHeap();
  }

  @Test
  public void testMedian() {
    heap.add(1);
    heap.add(4);
    heap.add(6);
    heap.add(12);
    heap.add(3);

    assertEquals(4f, heap.getMedian(), 0.0001f);
  }

}
