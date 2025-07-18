package sort;

import java.util.Arrays;
public class QuickSort {

  public static int partition(int arr[], int low, int high) {
    int pivot = arr[low];
    int lowIndex = low;
    int highIndex = high;

    while(lowIndex < highIndex) {
      while(arr[lowIndex] <= pivot && lowIndex < highIndex) {
        lowIndex ++;
      }
      while(arr[highIndex] > pivot) {
        highIndex --;
      }
      if(lowIndex < highIndex) {
        swap(arr, lowIndex, highIndex);
      }
    }

    swap(arr, low, highIndex);

    System.out.println("Pivot: " + pivot);
    System.out.println(Arrays.toString(arr));
    return highIndex;
  }

  public static void swap(int[] array, int from, int to) {
    int temp = array[to];
    array[to] = array[from];
    array[from] = temp;
  }

  public static void sort(int arr[], int low, int high)
  {
    if (low < high)
    {
      int pi = partition(arr, low, high);

      sort(arr, low, pi-1);
      sort(arr, pi+1, high);
    }
  }

  public static void main(String[] args) {
    int[] array = new int[] {4, 1, 3, 10, 9, 25, 5, 1, 2};
    System.out.println("Before: " + Arrays.toString(array));
    sort(array, 0 ,8);
    System.out.println("Sorted: " + Arrays.toString(array));
  }
}
