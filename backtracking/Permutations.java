package backtracking;

// https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
  static class Solution {
    List<List<Integer>> permute(int[] nums) {
      var result = new ArrayList<List<Integer>>();
      backtrack(nums, 0, result);
      return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {
      if (start == nums.length) {
        var permutation = new ArrayList<Integer>();
        for (int num : nums) {
          permutation.add(num);
        }
        result.add(permutation);
        return;
      }

      for (int i = start; i < nums.length; i++) {
        swap(nums, start, i);
        backtrack(nums, start + 1, result);
        swap(nums, start, i);
      }
    }

    private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().permute(new int[] {1, 2, 3}));
  }
}
