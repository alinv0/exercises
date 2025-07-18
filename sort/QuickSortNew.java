package sort;

public class QuickSortNew {
  public static void sort(int[] array, int lowIndex, int highIndex) {
    if(lowIndex >= highIndex) {
      return;
    }

    final int low = partition(array, lowIndex, highIndex);
    sort(array, lowIndex, low - 1);
    sort(array, low + 1, highIndex);
  }

  private static int partition(final int[] array, final int lowIndex, final int highIndex) {
    int pivot = array[highIndex];
    int low = lowIndex;
    int high = highIndex;
    while (low < high) {
      while(array[low] < pivot && low < high) {
        low ++;
      }
      while(array[high] >= pivot && low < high) {
        high --;
      }
      if(low < high) {
        swap(array, low, high);
      }
    }
    swap(array, highIndex, low);
    return low;
  }

  private static void swap(final int[] array, final int low, final int high) {
    int temp = array[low];
    array[low] = array[high];
    array[high] = temp;
  }

  public static void main(String[] args) {
    //Generate random array
    int[] array = new int[10];
    for(int i=0; i<array.length; i++) {
      array[i] = (int) (Math.random() * 100);
    }
    System.out.println("Unsorted array: " + java.util.Arrays.toString(array));
    sort(array, 0, array.length - 1);
    System.out.println("Sorted array: " + java.util.Arrays.toString(array));
  }
}
