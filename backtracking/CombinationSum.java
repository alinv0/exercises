package backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum

public class CombinationSum {
  static class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> result = new ArrayList<>();
      backtrack(candidates, target, 0, new ArrayList<>(), result);
      return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
      if (target == 0) {
        result.add(new ArrayList<>(combination));
        return;
      }

      if (target < 0) {
        return;
      }

      for (int i = start; i < candidates.length; i++) {
        combination.add(candidates[i]);
        backtrack(candidates, target - candidates[i], i, combination, result);
        combination.remove(combination.size() - 1);
      }
      return;
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().combinationSum(new int[] {2, 3, 6, 7}, 7));
  }
}
