package heap;

// https://leetcode.com/problems/kth-largest-element-in-an-array

import java.util.PriorityQueue;

public class KthLargestElement {
  static class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
      
      for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) {
          minHeap.poll();
        }
      }
      
      return minHeap.peek();
    }
  }

  public static void main(String[] args){
    Solution solution = new Solution();
    int[] nums = {3, 2, 1, 5, 6, 4};
    int k = 2;
    System.out.println(solution.findKthLargest(nums, k)); // Output: 5
    nums = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
    k = 4;
    System.out.println(solution.findKthLargest(nums, k)); // Output: 4
  }
}
