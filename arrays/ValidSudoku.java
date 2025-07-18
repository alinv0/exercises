package arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Check whether a 9 X 9 2D array representing a partially completed Sudoku is valid.
 * Specifically, check that no row, column, or 3 X 3 2D subarray contains duplicates. A
 * 0-value in the 2D array indicates that entry is blank; every other entry is in [1,9].
 */
public class ValidSudoku {
  public static boolean isValidSudoku(Integer[][] board) {
    // Check if board is 9x9
    if (board.length != 9 || board[0].length != 9) {
      return false;
    }
    
    for (final Integer[] integers : board) {
      if (!isValidList(integers)) {
        return false;
      }
    }

    for (int j = 0; j < board.length; j++) {
      Integer[] column = new Integer[board.length];
      for (int i = 0; i < board.length; i++) {
        column[i] = board[i][j];
      }

      // Call the validation method for each column
      if (!isValidList(column)) {
        return false; // Column is not valid
      }
    }

    for(int i=0; i<board.length; i+=3) {
      for(int j=0; j<board.length; j+=3) {
        Integer[] region = new Integer[9];
        int k = 0;
        for(int x=i; x<i+3; x++) {
          for(int y=j; y<j+3; y++) {
            region[k++] = board[x][y];
          }
        }
        if(!isValidList(region)) {
          return false;
        }
      }
    }

    return true;
  }

  private static boolean isValidList(final Integer[] list) {
    if(list.length != 9) {
      return false;
    }

    List<Integer> values = Stream.of(list).filter(i -> i != 0).toList();
    Set<Integer> uniqueValues = new HashSet<>(values);
    return values.size() == uniqueValues.size(); // Fixed: should be equal, not not equal
  }

  /**
   * Test sudoku boards of 9x9 elements where 0 represents an empty cell
   */
  public static void main(String[] args){
    // Valid Sudoku board
    Integer[][] validBoard = {
      {5,3,0,0,7,0,0,0,0},
      {6,0,0,1,9,5,0,0,0},
      {0,9,8,0,0,0,0,6,0},
      {8,0,0,0,6,0,0,0,3},
      {4,0,0,8,0,3,0,0,1},
      {7,0,0,0,2,0,0,0,6},
      {0,6,0,0,0,0,2,8,0},
      {0,0,0,4,1,9,0,0,5},
      {0,0,0,0,8,0,0,7,9}
    };
    
    System.out.println("Valid Sudoku: " + isValidSudoku(validBoard));
    
    // Invalid Sudoku board (duplicate in first row)
    Integer[][] invalidBoard = {
      {5,3,5,0,7,0,0,0,0}, // Duplicate 5 in first row
      {6,0,0,1,9,5,0,0,0},
      {0,9,8,0,0,0,0,6,0},
      {8,0,0,0,6,0,0,0,3},
      {4,0,0,8,0,3,0,0,1},
      {7,0,0,0,2,0,0,0,6},
      {0,6,0,0,0,0,2,8,0},
      {0,0,0,4,1,9,0,0,5},
      {0,0,0,0,8,0,0,7,9}
    };
    
    System.out.println("Invalid Sudoku: " + isValidSudoku(invalidBoard));
  }
} 