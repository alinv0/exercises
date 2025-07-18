package arrays;

// Given a matrix of size n x m, find how many sequences of 1s of length k are there in the matrix.
// Sequences can be horizontal (rows), vertical (columns), or diagonal (both main and anti-diagonals).
// A sequence is considered valid if it contains k consecutive 1s in any of these directions.

import java.util.Arrays;

public class SequenceInMatrix {
  static class Solution {
    public int findSequences(int[][] matrix, int k) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
        return 0;
      }
      
      int total = 0;
      int rows = matrix.length;
      int cols = matrix[0].length;
      
      // Check horizontal sequences (rows)
      for (int i = 0; i < rows; i++) {
        total += countSequencesInRow(matrix[i], k);
      }
      
      // Check vertical sequences (columns)
      for (int j = 0; j < cols; j++) {
        total += countSequencesInColumn(matrix, j, k);
      }
      
      // Check diagonal sequences (top-left to bottom-right)
      for (int i = 0; i <= rows - k; i++) {
        for (int j = 0; j <= cols - k; j++) {
          total += countSequencesInDiagonal(matrix, i, j, k, true);
        }
      }
      
      // Check anti-diagonal sequences (top-right to bottom-left)
      for (int i = 0; i <= rows - k; i++) {
        for (int j = k - 1; j < cols; j++) {
          total += countSequencesInDiagonal(matrix, i, j, k, false);
        }
      }
      
      return total;
    }
    
    private int countSequencesInRow(int[] row, int k) {
      int count = 0;
      int consecutive = 0;
      
      for (int i = 0; i < row.length; i++) {
        if (row[i] == 1) {
          consecutive++;
          if (consecutive >= k) {
            count++;
          }
        } else {
          consecutive = 0;
        }
      }
      
      return count;
    }
    
    private int countSequencesInColumn(int[][] matrix, int col, int k) {
      int count = 0;
      int consecutive = 0;
      
      for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][col] == 1) {
          consecutive++;
          if (consecutive >= k) {
            count++;
          }
        } else {
          consecutive = 0;
        }
      }
      
      return count;
    }
    
    private int countSequencesInDiagonal(int[][] matrix, int startRow, int startCol, int k, boolean isMainDiagonal) {
      int count = 0;
      int consecutive = 0;
      
      for (int i = 0; i < k; i++) {
        int row = startRow + i;
        int col = isMainDiagonal ? startCol + i : startCol - i;
        
        if (row < matrix.length && col >= 0 && col < matrix[0].length) {
          if (matrix[row][col] == 1) {
            consecutive++;
            if (consecutive >= k) {
              count++;
            }
          } else {
            consecutive = 0;
          }
        } else {
          consecutive = 0;
        }
      }
      
      return count;
    }
  }
  
  public static void main(String[] args) {
    Solution solution = new Solution();
    
    // Test case 1: Simple matrix with horizontal sequences
    int[][] matrix1 = {
      {1, 1, 1, 0},
      {0, 1, 1, 1},
      {1, 0, 1, 0}
    };
    System.out.println("Matrix 1 sequences of length 2: " + solution.findSequences(matrix1, 2)); // Expected: 14
    System.out.println("Matrix 1 sequences of length 3: " + solution.findSequences(matrix1, 3)); // Expected: 5
    
    // Test case 2: Matrix with vertical sequences
    int[][] matrix2 = {
      {1, 0, 1},
      {1, 0, 1},
      {1, 0, 1},
      {0, 0, 1}
    };
    System.out.println("\nMatrix 2 sequences of length 3: " + solution.findSequences(matrix2, 3)); // Expected: 3
    
    // Test case 3: Matrix with diagonal sequences
    int[][] matrix3 = {
      {1, 0, 0},
      {0, 1, 0},
      {0, 0, 1}
    };
    System.out.println("\nMatrix 3 sequences of length 3: " + solution.findSequences(matrix3, 3)); // Expected: 1
    
    // Test case 4: Empty matrix
    int[][] matrix4 = {};
    System.out.println("\nMatrix 4 sequences of length 2: " + solution.findSequences(matrix4, 2)); // Expected: 0
    
    // Test case 5: Matrix with no sequences
    int[][] matrix5 = {
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0}
    };
    System.out.println("\nMatrix 5 sequences of length 2: " + solution.findSequences(matrix5, 2)); // Expected: 0
  }
} 