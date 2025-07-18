package heap;

// https://leetcode.com/problems/smallest-number-in-infinite-set

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {
  static class SmallestInfiniteSet {

    PriorityQueue<Integer> minHeap;
    HashSet<Integer> addedBack;
    int currentSmallest;

    public SmallestInfiniteSet() {
      minHeap = new PriorityQueue<>();
      addedBack = new HashSet<>();
      currentSmallest = 1;
    }

    public int popSmallest() {
      if (!minHeap.isEmpty()) {
        int smallest = minHeap.poll();
        addedBack.remove(smallest);
        return smallest;
      }
      return currentSmallest++;
    }

    public void addBack(int num) {
      if (num < currentSmallest && addedBack.add(num)) {
        minHeap.offer(num);
      }
    }
  }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
}
