package com.arkumbra.ds.tree;

import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;

public class SortedBinaryTreeTest {
  private Tree<Integer> tree;

  @Before
  public void setUp() {
    this.tree = new SortedBinaryTree<>(((o1, o2) -> o1-o2));
  }

  @Test
  public void test() {
    tree.add(3);
    tree.add(1);
    tree.add(7);
    tree.add(7);
    tree.add(7);
    tree.add(2);
    tree.add(5);
    tree.add(8);
    tree.add(9);
    tree.add(9);
    tree.add(9);
    tree.add(10);
    tree.add(11);
    tree.add(11);
    tree.add(59);
    tree.add(59);
    tree.add(22);


    System.out.println(tree);


  }

}
