package binarysearch;

// https://leetcode.com/problems/guess-number-higher-or-lower

public class GuessNumber {
  static final int pick = 1702766719;

  static class Solution {
    private int guess(int num) {
      return Integer.compare(num, pick);
    }

    public int guessNumber(int n) {
      int start = 1;
      int end = n;

      while (start <= end) {
        int mid = start + (end - start) / 2; // Avoids potential overflow
        int result = guess(mid);

        if (result == 0) {
          return mid;
        } else if (result < 0) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }
      return -1;
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().guessNumber(2126753390));
  }
}
