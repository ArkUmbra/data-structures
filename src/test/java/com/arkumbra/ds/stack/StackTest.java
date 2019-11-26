package com.arkumbra.ds.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

  private static final int FIXED_STACK_SIZE = 12;
  private List<Stack<Integer>> fixedSizeStacks;
  private List<Stack<Integer>> unfixedSizeStacks;


  @Before
  public void setUp() {
    fixedSizeStacks = new ArrayList<>();
    unfixedSizeStacks = new ArrayList<>();

    // Add implementations here
    fixedSizeStacks.add(new SimpleFixedArrayStack<>(FIXED_STACK_SIZE));

    unfixedSizeStacks.add(new ArrayListStack<>());
  }

  @Test
  public void testPushPop() {
    for (Stack<Integer> stack : fixedSizeStacks) {
      System.out.println("Testing " + stack.getClass().getSimpleName());
      doSimplePushPop(stack);
    }

    for (Stack<Integer> stack : unfixedSizeStacks) {
      System.out.println("Testing " + stack.getClass().getSimpleName());
      doSimplePushPop(stack);
    }
  }

  private void doSimplePushPop(Stack<Integer> stack) {
    int elemToAdd = 5;

    assertTrue(stack.isEmpty());
    stack.push(elemToAdd);

    assertFalse(stack.isEmpty());
    int popped = stack.pop();

    assertEquals(elemToAdd, popped);
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testPushPopWithLargeAmountOfInputs() {

    for (Stack<Integer> stack : fixedSizeStacks) {
      System.out.println("Testing " + stack.getClass().getSimpleName());
      doPushPopLarge(stack, true);
    }

    for (Stack<Integer> stack : unfixedSizeStacks) {
      System.out.println("Testing " + stack.getClass().getSimpleName());
      doPushPopLarge(stack, false);
    }
  }

  private void doPushPopLarge(Stack<Integer> stack, boolean isFixedSize) {
    int maxElems = isFixedSize ? FIXED_STACK_SIZE : 1000000;

    List<Integer> allElems = new ArrayList<>();

    assertTrue(stack.isEmpty());

    // Add a bunch of elements
    Random r = new Random();
    for (int i = 0; i < maxElems; i++) {
      int num = r.nextInt();
      allElems.add(num);

      stack.push(num);
    }

    // Pop them all
    for (int i = allElems.size() - 1; i >= 0; i--) {
      int expected = allElems.get(i);
      int found = stack.pop();

      assertEquals(expected, found);
    }

    assertTrue(stack.isEmpty());
  }

}
