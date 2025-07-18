package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */
public class JumpingOnClouds {

  public static void main(String[] args){
    System.out.println(jumpingOnClouds(
        Arrays.asList(0,0,1,0,0,1,0)));
    System.out.println(jumpingOnClouds(
        Arrays.asList(0,1,0,0,0,1,0,0)));
  }
  
  public static int jumpingOnClouds(List<Integer> c) {
    int moves = 0;
    int i = 0;
    
    while (i < c.size() - 1) {
      // Try to jump 2 steps if possible
      if (i + 2 < c.size() && c.get(i + 2) == 0) {
        i += 2;
      } else {
        i += 1;
      }
      moves++;
    }
    
    return moves;
  }
} 