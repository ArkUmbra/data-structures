package com.arkumbra.ds.tree;

import java.util.Comparator;
import java.util.Iterator;

/**
 * See also: TreeSet
 * @param <T>
 */
public class SortedBinaryTree<T> implements Tree<T>, Iterable<T> {

  private SortedBinaryTree<T> leafLeft;
  private SortedBinaryTree<T> leafRight;
  private T val;

  // used for iteration
  private SortedBinaryTree<T> parent;

  private Comparator<T> comparator;

  public SortedBinaryTree(Comparator<T> comparator) {
    this.comparator = comparator;
  }

  public SortedBinaryTree(Comparator<T> comparator, SortedBinaryTree<T> parent) {
    this.comparator = comparator;
    this.parent = parent;
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
      leafLeft = new SortedBinaryTree<>(comparator, this);
    }
  }

  private void pushRight(T t) {
    createRightNodeIfDoesntExist();

    leafRight.add(t);
  }

  private void createRightNodeIfDoesntExist() {
    if (leafRight == null) {
      leafRight = new SortedBinaryTree<>(comparator, this);
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

  @Override
  public Iterator<T> iterator() {
    return new SortedBinaryTreeIterator(this);
  }



  class SortedBinaryTreeIterator implements Iterator<T> {
    private SortedBinaryTree<T> next;

    public SortedBinaryTreeIterator(SortedBinaryTree<T> root) {
      this.next = getLeftMost(root);
    }

    @Override
    public boolean hasNext() {
      return next != null;
    }

    @Override
    public T next() {
      T nextVal = next.val;

      // https://stackoverflow.com/questions/12850889/in-order-iterator-for-binary-tree
      // If you can walk right, walk right, then fully left.
      if (next.leafRight != null) {
        next = getLeftMost(next.leafRight);
        return nextVal;
      }

      // otherwise, walk up until you come from left.
      while (true) {
        // if we're at the root/parent node, go down the right
        if (next.parent == null) {
          next = null;
          return nextVal;
        }

        // If the parent's left leaf is the same as current, then means we're walking up the left
        else if (next == next.parent.leafLeft) {
          next = next.parent;
          return nextVal;

        } else {
          next = next.parent;
        }
      }
    }

    private SortedBinaryTree<T> getLeftMost(SortedBinaryTree<T> node) {
      SortedBinaryTree<T> leftMost = node;
      while (leftMost.leafLeft != null) {
        leftMost = leftMost.leafLeft;
      }
      return leftMost;
    }

  }

}