package stack;

// https://leetcode.com/problems/removing-stars-from-a-string

import java.util.Stack;

public class RemovingStars {
  static class Solution {
    public String removeStars(String s) {
      char[] chars = s.toCharArray();
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < chars.length; i++) {
        if (chars[i] == '*') {
          stack.pop();
        } else {
          stack.push(chars[i]);
        }
      }

      StringBuilder result = new StringBuilder();
      for (char c : stack) {
        result.append(c);
      }

      return result.toString();
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().removeStars("leet**cod*e"));
    System.out.println(new Solution().removeStars("erase*****"));
  }
}
