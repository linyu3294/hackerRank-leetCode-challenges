package com.company;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


  // swap 2 elements of an array,
  private static int [] swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
    return arr;
  }

  // Solution method that invokes helper method optimalHeapsGenerate()
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> results= new ArrayList<>();
    optimalHeapsGenerate(results, nums.length, nums);
    return results;
  }

  // Heap's Algorithm for finding permuations
  // Recursively generates all permuations of an array in Optimized Order
  private static void optimalHeapsGenerate(List<List<Integer>> results, int k, int[] arr) {
    // if size becomes 1 then prints the obtained
    // permutation
    if (k == 1)
      {appendPerm(results, arr);}
    else {optimalHeapsGenerate(results,k-1, arr);}

    for (int i = 0; i < k-1; i++) {
      // if size is odd, swap first and last
      // element
      if (k % 2 == 1) {
        swap(arr, 0, k-1);
      }
      // If size is even, swap ith and last
      // element
      else if (k % 2 == 0 ) {
        swap (arr, i, k-1);
      }
      optimalHeapsGenerate(results,k-1, arr);
    }
  }

  // Accrues each permutation and adds to a result List object.
  private static void appendPerm(List<List<Integer>> results, int a[])
  {
    List<Integer> eachPerm = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      eachPerm.add(a[i]);
    }
    results.add(eachPerm);
  }

  // main()
  public static void main(String[] args) {
    // Test cases and main driver that calls permute (int [] nums)

    System.out.println("Test 1");
    System.out.println("Expected Result: ");
    int n = 3;

    ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>(n);

    ArrayList<Integer> l1 = new ArrayList<Integer>();
    l1.addAll(Arrays.asList(1, 2, 3));
    ArrayList<Integer> l2 = new ArrayList<Integer>();
    l2.addAll(Arrays.asList(1, 3, 2));
    ArrayList<Integer> l3 = new ArrayList<Integer>();
    l3.addAll(Arrays.asList(2, 1, 3));
    ArrayList<Integer> l4 = new ArrayList<Integer>();
    l4.addAll(Arrays.asList(2, 3, 1));
    ArrayList<Integer> l5 = new ArrayList<Integer>();
    l5.addAll(Arrays.asList(3, 1, 2));
    ArrayList<Integer> l6 = new ArrayList<Integer>();
    l6.addAll(Arrays.asList(3, 2, 1));

    aList.add(l1);
    aList.add(l2);
    aList.add(l3);
    aList.add(l4);
    aList.add(l5);
    aList.add(l6);

    for (ArrayList<Integer> integerArrayList : aList) {
      for (Integer integer : integerArrayList) {
        System.out.print(integer + " ");
      }
      System.out.println();
    }

    System.out.println("Actual Results");
    List<List<Integer>> results = permute(new int[] {1});
    for (List<Integer> integerArrayList : results) {
      for (Integer integer : integerArrayList) {
        System.out.print(integer + " ");
      }
      System.out.println();
    }

  }
}
