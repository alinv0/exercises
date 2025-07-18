package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  static class Solution {
    public List<String> generateParenthesis(int n) {
      if (n < 1 || n > 8) {
        return new ArrayList<>();
      }

      var parList = new ArrayList<String>();

      backtrack(n, 0, 0, new StringBuilder(), parList);
      return parList;
    }

    private void backtrack(
        int n, int noLeft, int noRight, StringBuilder combination, List<String> result) {
      if (combination.length() == 2 * n) {
        result.add(combination.toString());
        return;
      }

      if (noLeft < n) {
        backtrack(n, noLeft + 1, noRight, combination.append("("), result);
        combination.deleteCharAt(combination.length() - 1); // backtrack
      }

      if (noRight < noLeft) {
        backtrack(n, noLeft, noRight + 1, combination.append(")"), result);
        combination.deleteCharAt(combination.length() - 1); // backtrack
      }
    }
  }

  public static void main(String[] args) {
    var solution = new Solution();
    var pars = solution.generateParenthesis(1);
    System.out.println(String.join(",", pars));
    pars = solution.generateParenthesis(2);
    System.out.println(String.join(",", pars));
    pars = solution.generateParenthesis(3);
    System.out.println(String.join(",", pars));
  }
} 