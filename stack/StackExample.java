package stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackExample {

  public static void main(String[] args){
    Deque<Integer> stack = new LinkedList<>();
    
    // Push elements onto the stack
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    
    System.out.println("Stack: " + stack);
    
    // Pop elements from the stack
    while (!stack.isEmpty()) {
      System.out.println("Popped: " + stack.pop());
    }
    
    // Demonstrate LIFO behavior
    System.out.println("\nDemonstrating LIFO behavior:");
    stack.push(10);
    stack.push(20);
    stack.push(30);
    
    System.out.println("Top element: " + stack.peek());
    System.out.println("Stack size: " + stack.size());
    
    // Pop all elements
    while (!stack.isEmpty()) {
      System.out.println("Popped: " + stack.pop());
    }
  }
} 