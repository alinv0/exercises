package stack;

// https://leetcode.com/problems/decode-string

import java.util.Stack;

public class DecodeString {
  static class Solution {
    public String decodeString(String s) {
      Stack<Integer> countStack = new Stack<>();
      Stack<StringBuilder> stringStack = new Stack<>();
      StringBuilder currentString = new StringBuilder();
      int count = 0;

      for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) {
          count = count * 10 + (c - '0');
        } else if (c == '[') {
          countStack.push(count);
          stringStack.push(currentString);
          count = 0;
          currentString = new StringBuilder();
        } else if (c == ']') {
          int repeatCount = countStack.pop();
          StringBuilder repeatedString = new StringBuilder();
          for (int i = 0; i < repeatCount; i++) {
            repeatedString.append(currentString);
          }
          currentString = stringStack.pop().append(repeatedString);
        } else {
          currentString.append(c);
        }
      }

      return currentString.toString();
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().decodeString("3[a]2[bc]"));
    System.out.println(new Solution().decodeString("3[a2[c]]"));
    System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
  }
}
