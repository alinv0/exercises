package sort;

import java.util.Arrays;

// (problem statement or link here if needed)

public class MergeSort_02 {

  public static void mergeSort(int[] a, int n) {
    if(n < 2) {
      return;
    }

    int mid = n/2;
    int[] l = Arrays.copyOfRange(a, 0, mid);
    int[] r = Arrays.copyOfRange(a, mid, n);

    mergeSort(l, mid);
    mergeSort(r, n-mid);

    merge(a, l, r);
  }

  public static void merge(int[] a, int[] l, int[] r) {
    int lsize = l.length;
    int rsize = r.length;
    int i=0, j=0, k = 0;

    while(i<lsize && j<rsize) {
      if(l[i] <= r[j]) {
        a[k++] = l[i++];
      } else {
        a[k++] = r[j++];
      }
    }

    while(i<lsize) {
      a[k++] = l[i++];
    }

    while(j<rsize) {
      a[k++] = r[j++];
    }
  }

  public static void main(String[] args){
    int[] a = {5, 2, 6, 1, 3, 7, 2};
    mergeSort(a, a.length);
    Arrays.stream(a).forEach(System.out::println);
  }
}
