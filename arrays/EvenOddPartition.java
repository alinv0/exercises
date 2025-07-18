package arrays;

// Reorder an array of integers so that even entries appear first, followed by odd entries.
// Solve this without allocating additional storage (in-place algorithm).
// Time complexity: O(n), Space complexity: O(1)
public class EvenOddPartition {

  public static void evenOdd(int[] array) {
    int evenIndex = 0;
    int oddIndex = array.length - 1;
    
    while(evenIndex < oddIndex) {
      if(array[evenIndex] % 2 != 0) {
        // Current element is odd, swap with element at oddIndex
        int temp = array[evenIndex];
        array[evenIndex] = array[oddIndex];
        array[oddIndex] = temp;
        oddIndex--;
      } else {
        // Current element is even, move to next
        evenIndex++;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println("Original array: " + java.util.Arrays.toString(arr));
    evenOdd(arr);
    System.out.println("After even-odd partition: " + java.util.Arrays.toString(arr));
    
    int[] arr2 = {1, 3, 5, 7, 9};
    System.out.println("\nOriginal array: " + java.util.Arrays.toString(arr2));
    evenOdd(arr2);
    System.out.println("After even-odd partition: " + java.util.Arrays.toString(arr2));
    
    int[] arr3 = {2, 4, 6, 8, 10};
    System.out.println("\nOriginal array: " + java.util.Arrays.toString(arr3));
    evenOdd(arr3);
    System.out.println("After even-odd partition: " + java.util.Arrays.toString(arr3));
  }
} 