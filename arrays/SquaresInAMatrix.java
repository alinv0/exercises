package arrays;

// https://www.geeksforgeeks.org/problems/squares-in-a-matrix5716/1

public class SquaresInAMatrix {
  static class Solution {
    public static int squaresInMatrix(int m, int n) {
      int totalSquares = 0;
      for(int i=0; i<Integer.min(m, n); i++) {
        totalSquares += (m-i) * (n-i);
      }

      return totalSquares;
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().squaresInMatrix(4, 9));
  }
} 