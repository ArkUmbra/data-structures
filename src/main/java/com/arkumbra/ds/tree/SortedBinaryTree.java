package com.arkumbra.ds.tree;

import java.util.Comparator;
import java.util.Iterator;

/**
 * See also: TreeSet
 * @param <T>
 */
public class SortedBinaryTree<T> implements Tree<T> {

  private SortedBinaryTree<T> leafLeft;
  private SortedBinaryTree<T> leafRight;
  private T val;

  private Comparator<T> comparator;

  public SortedBinaryTree(Comparator<T> comparator) {
    this.comparator = comparator;
  }


  @Override
  public void add(T t) {
    if (val == null) {
      this.val = t;

    } else {
      pushDownToLeaves(t);
    }

  }

  private void pushDownToLeaves(T t) {
    int compared = comparator.compare(t, this.val);
    if (compared < 0) {
      pushLeft(t);

    } else if (compared == 0) {
      pushLeft(t);
      //throw new RuntimeException("Hello test");

    } else {
      pushRight(t);

    }
  }

  private void pushLeft(T t) {
    createLeftNodeIfDoesntExist();

    leafLeft.add(t);
  }

  private void createLeftNodeIfDoesntExist() {
    if (leafLeft == null) {
      leafLeft = new SortedBinaryTree<>(comparator);
    }
  }

  private void pushRight(T t) {
    createRightNodeIfDoesntExist();

    leafRight.add(t);
  }

  private void createRightNodeIfDoesntExist() {
    if (leafRight == null) {
      leafRight = new SortedBinaryTree<>(comparator);
    }
  }



  @Override
  public T get(int index) {
    return null;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    if (leafLeft != null) {
      String lf = leafLeft.toString();
      sb.append(leafLeft);
      if (! lf.endsWith(" ")) {
        sb.append(" ");
      }
    }
    sb.append(val).append(" ");
    if (leafRight != null) {
      sb.append(leafRight);
    }
    return sb.toString();
  }

  //  @Override
//  public Iterator<T> iterator() {
//    return null;
//  }
}
