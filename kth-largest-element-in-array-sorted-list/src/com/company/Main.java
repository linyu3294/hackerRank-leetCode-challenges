package com.company;

import java.util.*;

public class Main {

  public static int findKthLargest(int[] nums, int k) {
    Integer[] arrInteger = Arrays.stream( nums ).boxed().toArray( Integer[]::new );
    ArrayList<Integer> arrList = new ArrayList<Integer>(Arrays.asList(arrInteger));
    arrList.sort((a, b) -> a-b);
    Collections.reverse(arrList);
    return arrList.get(k+1);
  }

  // Test cases and Main() driver
  public static void main(String[] args) {
    System.out.println( findKthLargest (new int[] {3,2,3,1,2,4,5,5,6}, 3));
  }
}
