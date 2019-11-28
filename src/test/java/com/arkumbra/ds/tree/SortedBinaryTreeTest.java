package com.arkumbra.ds.tree;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class SortedBinaryTreeTest {
  private SortedBinaryTree<Integer> tree;

  @Before
  public void setUp() {
//    this.tree = new SortedBinaryTree<>(((o1, o2) -> o1-o2));
    this.tree = new SortedBinaryTree<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if (o1 == o2) {
          return 0;
        } else if (o1 < o2) {
          return -1;
        } else {
          return 1;
        }
      }
    });
  }

  @Test
  public void test() {
    Random r = new Random();

    for (int i = 0; i < 1000; i++) {
      tree.add(r.nextInt());
    }
    //System.out.println("Tree is " + tree + "\n");

    // Check results
    Long sum = 0L;
    Integer prev = null;
    for (Integer i : tree) {
      sum += i;
      //System.out.println("Found " + i);

      if (prev == null) {
        prev = i;
      } else {
        assertTrue("Previous number " + prev + ", but current " + i, i > prev);
      }

    }

    System.out.println("Total value of tree " + sum);
  }

}
