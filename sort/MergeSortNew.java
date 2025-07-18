package sort;

public class MergeSortNew {

  public static void mergeSort(int[] array) {
    int arraySize = array.length;
    if(arraySize < 2) {
      return;
    }

    int midIndex = arraySize/2;

    int[] leftHalf = new int[midIndex];
    int[] rightHalf = new int[arraySize-midIndex];

    System.arraycopy(array, 0, leftHalf, 0, midIndex);
    System.arraycopy(array, midIndex, rightHalf, 0, arraySize-midIndex);

    mergeSort(leftHalf);
    mergeSort(rightHalf);

    merge(array, leftHalf, rightHalf);
  }

  private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
    int leftSize = leftHalf.length;
    int rightSize = rightHalf.length;

    int i=0, j=0, k=0;

    while(i<leftSize && j<rightSize) {
      if(leftHalf[i] <= rightHalf[j]) {
        array[k++] = leftHalf[i++];
      } else {
        array[k++] = rightHalf[j++];
      }
    }

    while(i<leftSize) {
      array[k++] = leftHalf[i++];
    }

    while(j<rightSize) {
      array[k++] = rightHalf[j++];
    }
  }

  public static void main(String[] args){
    int[] array = new int[20];
    for(int i=0; i<array.length; i++) {
      array[i] = (int) (Math.random() * 100);
    }
    System.out.println("Unsorted array: " + java.util.Arrays.toString(array));
    mergeSort(array);
    System.out.println("Sorted array: " + java.util.Arrays.toString(array));
  }
}
