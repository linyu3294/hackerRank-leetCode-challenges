package com.company;

public class Main {
  public static void swap(int[] arr, int a, int b) {
    int c = arr[a];
    arr[a] = arr[b];
    arr[b] = c;
  }

  public static int[] quickSort(int arr[], int begin, int end) {
    if (begin < end) {
      int partitionIndex = partition(arr, begin, end);

      quickSort(arr, begin, partitionIndex-1);
      quickSort(arr, partitionIndex+1, end);
    }
    return arr;
  }
  private static int partition(int arr[], int begin, int end) {
    int pivot = arr[end];
    int i = (begin-1);

    for (int j = begin; j < end; j++) {
      if (arr[j] <= pivot) {
        i++;

        int swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
      }
    }

    int swapTemp = arr[i+1];
    arr[i+1] = arr[end];
    arr[end] = swapTemp;

    return i+1;
  }

  public static int findKthLargest(int[] nums, int k) {

    int [] sortedResult = quickSort(nums, 0, nums.length-1);
    for (int num : nums) {
      System.out.println(num);
    }
    return sortedResult [nums.length-k];
  }

  // Test cases and Main() driver
  public static void main(String[] args) {
    System.out.println(findKthLargest(new int[] {5,2,4,1,3,6,0},4));
  }
}
