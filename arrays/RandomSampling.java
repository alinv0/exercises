package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Implement an algorithm that takes as input an array of distinct elements and a size,
 * and returns a subset of the given size of the array elements. All subsets should be
 * equally likely. Return the result in input array itself.
 */
public class RandomSampling {

  public static List<Integer> randomSampling(List<Integer> A, int size) {
    Random gen = new Random();
    for(int i = 0; i < size; i++) {
      Collections.swap(A, i, i + gen.nextInt(A.size() - i));
    }

    return A;
  }

  public static void main(String[] args){
    randomSampling(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 5).forEach(System.out::println);
  }
} 