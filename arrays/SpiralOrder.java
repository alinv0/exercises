package arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
// 
// Given an m x n matrix, return all elements of the matrix in spiral order.
// The spiral order starts from the top-left corner and goes clockwise.
public class SpiralOrder {

  public static List<Integer> spiralOrder(int[][] A) {
    List<Integer> result = new ArrayList<>();
    for(int i=0; i<A.length/2; i++) {
      result.addAll(order(A, i));
    }

    if(A.length%2 != 0) {
      result.add(A[A.length/2][A.length/2]);
    }

    return result;
  }

  public static List<Integer> order(int[][] A, int start) {
    List<Integer> result = new ArrayList<>();
    int from = start;
    int to = A.length-start-1;

    for(int i=from; i<to; i++) {
      result.add(A[from][i]);
    }

    for(int i=from; i<to; i++) {
      result.add(A[i][to]);
    }

    for(int i=to; i>from; i--) {
      result.add(A[to][i]);
    }

    for(int i=to; i>from; i--) {
      result.add(A[i][from]);
    }

    return result;
  }

  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] arr2 = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    int[][] arr3 = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25},
    };

    spiralOrder(arr).forEach(System.out::println);
    System.out.println();
    spiralOrder(arr2).forEach(System.out::println);
    System.out.println();
    spiralOrder(arr3).forEach(System.out::println);
  }
} 